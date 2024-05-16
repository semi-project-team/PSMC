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
        if('dschedule' in data) {
            data.dschedule.forEach(t => {
                const time = t.timeVal;
                const code = t.timeCode;
                let start = time.substring(0, time.length - 3);
                const end = ending(start);
                t.mItoProDTOS.forEach(m => {
                    const dayNum = m.day;
                    const mediDate = m.mediDate;
                    const mediCode = m.mediCode;
                    const p = m.connectProjectDTO.patientDTO
                    const age = p.age;
                    const name = p.patientName;
                    const injuryName = m.connectProjectDTO.injuryDTO.injuryName;

                    switch (dayNum) {
                        case 1:
                            makeSchedule(day1, start, end, name, injuryName, age, code, mediDate, mediCode)
                            break;
                        case 2:
                            makeSchedule(day2, start, end, name, injuryName, age, code, mediDate, mediCode)
                            break;
                        case 3:
                            makeSchedule(day3, start, end, name, injuryName, age, code, mediDate, mediCode)
                            break;
                        case 4:
                            makeSchedule(day4, start, end, name, injuryName, age, code, mediDate, mediCode)
                            break;
                        case 5:
                            makeSchedule(day5, start, end, name, injuryName, age, code, mediDate, mediCode)
                            break;
                        case 6:
                            makeSchedule(day6, start, end, name, injuryName, age, code, mediDate, mediCode)
                            break;
                        case 7:
                            makeSchedule(day7, start, end, name, injuryName, age, code, mediDate, mediCode)
                            break;
                    }
                })
            })
        }
        else if('tschedule' in data){
            data.tschedule.forEach(t=>{
                console.table(t);
                const dayNum = t.day;
                const theraDate = t.theraDate;
                const theraCode = t.theraCode;
                const p  = t.connectProjectDTO.patientDTO;
                const name = p.patientName;
                const age = p.age;
                const injuryName = t.connectProjectDTO.injuryDTO.injuryName;
                const start = t.start;
                const newStart = start.substring(0,start.length-3);
                const end = t.end;
                const newEnd = end.substring(0,end.length-3);
                switch (dayNum){
                    case 1:
                        makeSchedule(day1,newStart,newEnd,name,injuryName,age,'none',theraDate,theraCode);
                        break;
                    case 2:
                        makeSchedule(day2,newStart,newEnd,name,injuryName,age,'none',theraDate,theraCode);
                        break;
                    case 3:
                        makeSchedule(day3,newStart,newEnd,name,injuryName,age,'none',theraDate,theraCode);
                        break;
                    case 4:
                        makeSchedule(day4,newStart,newEnd,name,injuryName,age,'none',theraDate,theraCode);
                        break;
                    case 5:
                        makeSchedule(day5,newStart,newEnd,name,injuryName,age,'none',theraDate,theraCode);
                        break;
                    case 6:
                        makeSchedule(day6,newStart,newEnd,name,injuryName,age,'none',theraDate,theraCode);
                        break;
                    case 7:
                        makeSchedule(day7,newStart,newEnd,name,injuryName,age,'none',theraDate,theraCode);
                        break;

                }
            })
        }

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

                if(val!="none") {

                    $time.value = val;
                }


                const date = timeCode[2].split("/")[1];

                if(val!="none") {
                    const projectNo = $patientName.value
                    doDate(date,projectNo);
                }
                const mediCode = timeCode[3].split("-")[1];
                $date.value=date;
                $delete.style.display='block';
                const timeRange = b.parentElement.previousElementSibling.textContent;
                console.log(timeRange);
                if(val=="none"){
                   const startTime = timeRange.split("-")[0].trim();
                   const endTime = timeRange.split("-")[1].trim();
                   $start.value=startTime;
                   $end.value=endTime;
                }
                modiButton(mediCode);
                deleteButton(mediCode);
            })
        })


    })
const $patientName = document.getElementById('patientName');
const $time = document.getElementById('reservationTime');
const $date = document.getElementById('reservationDate');
const $start = document.getElementById('timeInput1');
const $end  = document.getElementById('timeInput2');
fetch("/alltime")
    .then(res=>res.json())
    .then(data=>{

            let projects = [];
            data.times.forEach(t => {
                console.table(t);
                if(data.pmCode.charAt(0)=='d'){
                    t.mItoProDTOS.forEach(m => {
                        const p = m.connectProjectDTO.projectNo;
                        if (projects.indexOf(p) === -1) {
                            projects.push(p);
                            const $option = document.createElement('option');
                            $option.textContent = `${m.connectProjectDTO.patientDTO.patientName}`;
                            $option.value = p;
                            $patientName.appendChild($option);
                        }

                    })
                }
                else{
                    const p = t.connectProjectDTO.projectNo;
                    if(projects.indexOf(p)===-1){
                        projects.push(p);
                        const $option = document.createElement('option');
                        $option.textContent = `${t.connectProjectDTO.patientDTO.patientName}`;
                        $option.value = p;
                        $patientName.appendChild($option);
                    }
                }

            })

    })

function doDate(dating,projectNo){
    console.log('date 들어옮');
    let times = [];
    fetch("/allProjects")
        .then(res=>res.json())
        .then(data=>{
            console.table(data);


            if(data.role == "doctor") {
                Array.from($time.options).forEach(function (option) {
                    option.disabled = false;
                })
                $time[0].disabled = true;
            }

                data.allMedi.forEach(m=>{
                    if(data.role == "doctor") {
                        m.mediInfoDTOS.forEach(t => {
                            if (t.mediDate == dating) {
                                times.push(t.timeCode);
                            }
                        })
                    }
                    else{
                        if(m.projectNo == projectNo){
                            m.mediInfoDTOS.forEach(t=>{
                                if(t.mediDate == dating){
                                    times.push(t.timeCode);
                                }
                            })
                        }
                    }
                })
                times.forEach(time=>{
                    if(data.role == "doctor") {
                        const $option = $time.querySelector(`option[value="${time}"]`);
                        $option.disabled = true;
                    }

                })
                data.allThera.forEach(thera=>{
                    console.table(thera);
                    console.log('thera 들어옴');
                    console.log(projectNo);
                    if(data.role == "doctor") {
                        if (thera.projectNo == projectNo) {
                            console.log('project no 맞음')
                            thera.theraInfoDTOS.forEach(info => {
                                if (info.theraDate == dating) {
                                    console.log('thera 날짜도 맞음')
                                    const startTime = info.start;
                                    const endTime = info.end;

                                    let code = [];
                                    for (let i = 1; i < 17; i++) {
                                        const startCode = startTimeCode(i);
                                        const endCode = endTimeCode(i);
                                        if (!(subtractTime(endCode, startTime) >= 0 || subtractTime(startCode, endTime) <= 0)) {
                                            code.push(i);
                                        }

                                    }
                                    code.forEach(i => {
                                        const $option = $time.querySelector(`option[value="${i}"]`);
                                        $option.disabled = true;
                                    })
                                }
                            })
                        }
                    }


                })

        })





}
function endTimeCode(i){
    switch (i){
        case 1: return "09:30:00";
        case 2: return "10:00:00";
        case 3: return "10:30:00";
        case 4: return "11:00:00";
        case 5: return "11:30:00";
        case 6: return "12:00:00";
        case 7: return "13:30:00";
        case 8: return "14:00:00";
        case 9: return "14:30:00";
        case 10: return "15:00:00";
        case 11: return "15:30:00";
        case 12: return "16:00:00";
        case 13: return "16:30:00";
        case 14: return "17:00:00";
        case 15: return "17:30:00";
        case 16: return "18:00:00";
    }

}
function startTimeCode(i){
    switch (i) {
        case 1: return '09:00:00';
        case 2: return '09:30:00';
        case 3: return '10:00:00';
        case 4: return '10:30:00';
        case 5: return '11:00:00';
        case 6: return '11:30:00';
        case 7: return '13:00:00';
        case 8: return '13:30:00';
        case 9: return '14:00:00';
        case 10: return '14:30:00';
        case 11: return '15:00:00';
        case 12: return '15:30:00';
        case 13: return '16:00:00';
        case 14: return '16:30:00';
        case 15: return '17:00:00';
        case 16: return '17:30:00';
        default: return null;
    }
}

function subtractTime(start, end) {
    // 시작 시간과 끝 시간을 Date 객체로 변환
    const startTime = new Date("1970-01-01T" + start + "Z");
    const endTime = new Date("1970-01-01T" + end + "Z");

    // 끝 시간에서 시작 시간을 빼서 시간 차이를 구함
    const timeDiff = endTime.getTime() - startTime.getTime();

   if(timeDiff>0){
       return  1;
   }
   else if(timeDiff<0){
       return  -1;
   }
   else{
       return 0;
   }
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

$date.addEventListener('change',function(){
    const projectNo = $patientName.value;
    doDate($date.value,projectNo);


});

$patientName.addEventListener('change',function (){
    const projectNo = $patientName.value;
    doDate($date.value,projectNo);
})

