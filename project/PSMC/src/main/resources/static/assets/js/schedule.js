const mon = document.getElementById('mon');
const tue = document.getElementById('tue');
const wed = document.getElementById('wed');
const thu = document.getElementById('thu');
const fri = document.getElementById('fri');
const sat = document.getElementById('sat');
const sun = document.getElementById('sun');
const date = [mon,tue,wed,thu,fri,sat,sun];

const day1 =document.getElementById('day1').firstElementChild;
const day2 =document.getElementById('day2').firstElementChild;
const day3 =document.getElementById('day3').firstElementChild;
const day4 =document.getElementById('day4').firstElementChild;
const day5 =document.getElementById('day5').firstElementChild;
const day6 =document.getElementById('day6').firstElementChild;
const day7 =document.getElementById('day7').firstElementChild;

fetch("/setSchedule")
    .then(res=>res.json())
    .then(data=>{
        console.table(data);
        let day = data.startDay;
        date[0].textContent=day;
        for(let i =1; i<date.length ; i++){
            day = increaseDateByOneDay(day);

            date[i].textContent = day;
        }
        data.schedule.forEach(t=>{
            const time = t.timeVal;
            const code = t.timeCode;
            let start = time.substring(0,time.length-3);
            const end = ending(start);
            t.mitoProDTOS.forEach(m=>{
                const dayNum = m.day;
                const mediDate = m.mediDate;
                const mediCode = m.mediCode;
                const p = m.connectProjectDTO.patientDTO
                const age = p.age;
                const name = p.name;
                const injuryName = m.connectProjectDTO.injuryDTO.injuryName;

                switch (dayNum){
                    case 1:
                        makeSchedule(day1,start,end,name,injuryName,age,code,mediDate,mediCode)
                        break;
                    case 2:
                        makeSchedule(day2,start,end,name,injuryName,age,code,mediDate,mediCode)
                        break;
                    case 3:
                        makeSchedule(day3,start,end,name,injuryName,age,code,mediDate,mediCode)
                        break;
                    case 4:
                        makeSchedule(day4,start,end,name,injuryName,age,code,mediDate,mediCode)
                        break;
                    case 5:
                        makeSchedule(day5,start,end,name,injuryName,age,code,mediDate,mediCode)
                        break;
                    case 6:
                        makeSchedule(day6,start,end,name,injuryName,age,code,mediDate,mediCode)
                        break;
                    case 7:
                        makeSchedule(day7,start,end,name,injuryName,age,code,mediDate,mediCode)
                        break;
                }
            })
        })

        const $modalButton = document.querySelectorAll('.button-6');
        $modalButton.forEach(b=>{
            b.addEventListener('click',e=>{
                const text = b.firstElementChild.textContent;
                Array.from($patientName.options).forEach(function(option){
                    if(option.textContent==text){
                        option.selected=true;
                    }
                })
                const timeCode = b.classList;
                const val = timeCode[1].split("-")[1];
                $time.value = val;

                const date = timeCode[2].split("/")[1];
                console.log('date 시작')
                doDate(date);
                const mediCode = timeCode[3].split("-")[1];
                $date.value=date;
                $delete.style.display='block';

                modiButton(mediCode);
                deleteButton(mediCode);
            })
        })


    })
const $patientName = document.getElementById('patientName');
const $time = document.getElementById('reservationTime');
const $date = document.getElementById('reservationDate');

fetch("/alltime")
    .then(res=>res.json())
    .then(data=>{
        let projects =[];
        data.forEach(t=>{
            console.table(t);
            t.mitoProDTOS.forEach(m=>{
                const p = m.connectProjectDTO.projectNo;
                if(projects.indexOf(p) === -1){
                    projects.push(p);
                    const $option =document.createElement('option');
                    $option.textContent=`${m.connectProjectDTO.patientDTO.name}`;
                    $option.value = p;
                    $patientName.appendChild($option);
                }

            })

        })

    })

function doDate(dating){
    console.log('date 들어옮')
    Array.from($time.options).forEach(function(option){
        option.disabled=false;

    })
    $time[0].disabled=true;
    let times = [];
    fetch("/alltime")
        .then(res=>res.json())
        .then(data=>{
            data.forEach(t=>{
                t.mitoProDTOS.forEach(m=>{
                    console.log('날짜주세요'+dating);
                    if(m.mediDate === dating){
                        console.log('똑같은가')
                        console.log(t.timeCode);
                        times.push(t.timeCode);
                    }
                })

            })
            if(times.length>0){
                for(let i = 0 ; i<times.length;i++){
                    console.log('시간 하나씩 꺼내자'+times[i]);
                    const $option = $time.querySelector(`option[value="${times[i]}"]`);
                    $option.disabled=true;

                }
            }
        })

    // if(times!=null){
    //     console.log('시작전')
    //     times.forEach(t=>{
    //         console.log('시간선이 이싼요')
    //         const $option = $time.querySelector(`option[value=${t}]`);
    //         $option.disabled=true;
    //     })
    // }
}

function increaseDateByOneDay(dateString){
    let date = new Date(dateString);
    date.setDate(date.getDate()+1);
    return date.toISOString().split('T')[0];
}
function ending(start){
    const timeParts = start.split(":");
    let hours = parseInt(timeParts[0],10);
    let minutes = parseInt(timeParts[1],10);
    minutes +=30;
    if(minutes>=60){
        hours++;
        minutes -=60;
    }

    const newTimeVal = hours.toString().padStart(2,"0")+":"+minutes.toString().padStart(2,"0");
    return newTimeVal;
}

function makeSchedule(day,start,end,name,injury,age,timeCode,mediDate,mediCode){
    const $ele = document.createElement('li');
    $ele.classList.add('d-flex', 'flex-column', 'flex-md-row', 'py-4');
    $ele.innerHTML=
        `<span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-black ">${start} - ${end}</span>
         <div class="flex-grow-1 ps-4 border-start border-3" style="color: black">
             <button class="button-6 timecode-${timeCode} date/${mediDate} mediCode-${mediCode}" data-bs-toggle="modal" data-bs-target="#exampleModal" style="display: flex; flex-direction: column;">
                 <h4>${name}</h4>
                 <p class="mb-0">
                    부상명 : ${injury}<br>
                    나이 : ${age}
                 </p>
             </button>
         </div>`
    day.appendChild($ele);

}

const $form = document.getElementById('formmer');
const $modify = document.getElementById('modifyBtn');
const $delete =document.getElementById('deleteBtn');
function modiButton(mediCode){
    $modify.addEventListener('click',function(){
        $form.action=`/update/${mediCode}`;
        $form.submit();
    })
}
function deleteButton(mediCode){
    $delete.addEventListener('click',function(){
        $form.action=`/delete/${mediCode}`;
        $form.submit();
    })
}

$form.addEventListener('change',e=>{
    $delete.style.display='none';
})

$date.addEventListener('change',function(){doDate($date.value)});
