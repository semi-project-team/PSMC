const checkDelete = document.querySelectorAll('[class^=delete-]:checked');

console.table(checkDelete);

const deleteButton = document.getElementById('deleteButton');
const param = new URLSearchParams();
deleteButton.addEventListener('click',e=>{
    const checkbox = [];
    if(checkDelete.length>0) {
        checkDelete.forEach(d => {
            if (d.checked) {
                param.append("theraNo", d.className.split('-')[1]);

            }
        })

        const queryString = param.toString();

        console.log(queryString);


        const nowPage = window.location.href;



        window.location.replace(`${nowPage}/deleteTheraLink?${queryString}`);
    }
})

const $blog = document.querySelectorAll('.blogPage');
const $sendingMessage =document.getElementById('sendingMessage');
const $inputMessage = document.getElementById('inputMessage');
$blog.forEach(b=>{

    b.addEventListener('click',e=>{
        const theraLinkNo = b.querySelector('[class^=delete-]').classList.toString().split("-")[1];

        console.log("theraLinkNo 잘 왔는가"+theraLinkNo);

        fetch("/theraLink/blog",{
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                theraNum : theraLinkNo
            })
        }).then(res=>res.json())
            .then(data=>{
                console.log('잘받았습니다')
                console.table(data);


                makeChatting(data);





            })


        $sendingMessage.addEventListener('click',e=>{
            if($inputMessage.value){
                const message =$inputMessage.value;
                fetch("/theraLink/addMessage",{
                    method: "POST",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        theraNum: theraLinkNo,
                        theraChatContent: message

                    })
                }).then(res=>res.json())
                    .then(data=>{
                        console.log('업데이트 잘됬는가?')
                        console.table(data);
                        makeChatting(data);
                    })
            }
        })


    })
})

function makeChatting(data){

    const $theraLinkTitle = document.getElementById('theraLinkTitle');
    const $theraLinkContents = document.getElementById('theraLinkContents');
    const $chattingarea = document.getElementById('chattingarea');
    $chattingarea.textContent="";
    const pmCode = data.me;
    $theraLinkTitle.textContent=data.theraTitle;
    $theraLinkContents.textContent=data.theraContents;


    data.theraChatForBlogDTOS.forEach(t=>{
        if(t.pmCode===pmCode){
            console.log('나다');
            const date = t.theraChatBoardDate.toString().split("T")
            const day = date[0];
            const time = date[1];

            const $chat = document.createElement('div');
            $chat.classList.add('chat-message-right','pb-4');
            $chat.innerHTML=`<div>
                                             <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle mr-1" alt="Chris Wood" width="40" height="40">
                                             <div class="text-muted small text-nowrap mt-2">${day}<br>${time}</div>
                                             <input type="checkbox" class="chatDelete">
                                          </div>
                                          <div class="flex-shrink-1 bg-light rounded py-2 px-3 mr-3">
                                              <div class="font-weight-bold mb-1" style="font-weight: bolder;">You</div>
                                                  ${t.theraChatContent}
                                          </div>`
            $chattingarea.appendChild($chat);

        }else{
            console.log('나 아니다');
            const date = t.theraChatBoardDate.toString().split("T")
            const day = date[0];
            const time = date[1];

            const $chat =document.createElement('div');
            $chat.classList.add('chat-message-left','pb-4');
            $chat.innerHTML=`<div>
                                            <img src="https://bootdey.com/img/Content/avatar/avatar3.png" class="rounded-circle mr-1" alt="Sharon Lessman" width="40" height="40">
                                             <div class="text-muted small text-nowrap mt-2">${day}<br>${time}</div>
                                         </div>
                                         <div class="flex-shrink-1 bg-light rounded py-2 px-3 ml-3">
                                           <div class="font-weight-bold mb-1">${t.name}</div>
                                                ${t.theraChatContent}
                                         </div>`

            $chattingarea.appendChild($chat);
        }
    })

}