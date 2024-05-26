

const deleteButton = document.getElementById('deleteButton');


if(deleteButton!=null) {
    deleteButton.addEventListener('click', e => {

        const checkDelete = Array.from(document.querySelectorAll('[class^=delete-]:checked'));
        const param = new URLSearchParams();
        if (checkDelete.length > 0) {
            checkDelete.forEach(d => {
                if (d.checked) {
                    param.append("theraNo", d.className.split('-')[1]);

                }
            })

            const queryString = param.toString();

            console.log(queryString);


            const nowPage = window.location.href;
            console.log(nowPage);


            window.location.replace(`${nowPage}/deleteTheraLink?${queryString}`);
        }
    })
}

const $blog = document.getElementsByClassName('blogPage');
const $bloglist = [...$blog];
const $sendingMessage =document.getElementById('sendingMessage');
const $inputMessage = document.getElementById('inputMessage');
$bloglist.forEach(b=>{

    b.addEventListener('click',e=>{
        const theraLinkNo = b.id;

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

                $chatDeleteButton.value="";
                $chatDeleteButton.value = theraLinkNo;

                makeChatting(data,theraLinkNo);


                console.table(data);
                console.log('theraLinkNo 바꼈겠지'+theraLinkNo);



                const $modifyTheraLink  = document.getElementById('modifyTheraLink');
                console.log('순서체크1')
                if($modifyTheraLink) {
                    console.log('왜 안오지')
                    $modifyTheraLink.addEventListener('click', e => {
                        console.log('클릭이벤트')
                        const $title = document.getElementById('title1');
                        $title.value = data.theraTitle;
                        const $contents = document.getElementById('TheraLink-contents1');
                        $contents.value = data.theraContents;

                        $(function () {


                                $('.input-images1').imageUploader();




                            $('#form-example-1').on('submit', function (event) {
                                event.preventDefault();
                                event.stopPropagation();

                                let formData = new FormData(document.getElementById('form-example-1'));

                                formData.append('theraTitle',$('#title1').val());
                                formData.append('contents',$('#TheraLink-contents1').val())
                                formData.append('theralinkNo',theraLinkNo);
                                let inputElements = document.querySelectorAll('.image-uploader1 input[type="file"]');


                                inputElements.forEach(inputElements => {
                                    let files = inputElements.files;
                                    if(files.length>0) {
                                        console.log('미리보기 파일 있나')
                                        for (let i = 0; i < files.length; i++) {
                                            formData.append('images', files[i]);

                                        }
                                    }
                                })


                                const nowPage = window.location.href;
                                const projectNo = nowPage.split("/")[5];
                                console.log('projectNo'+projectNo);

                                $.ajax({
                                    url: `/theraLink/theraModi/${projectNo}`,
                                    type: 'POST',
                                    data: formData,
                                    processData: false,
                                    contentType: false,
                                    success: function(response) {
                                        if(response.redirectURL){
                                            console.log('성공이요');
                                            window.location.href=response.redirectURL;
                                        }



                                    },
                                    error: function(xhr, status, error) {
                                        console.log('실패요');
                                        let response = JSON.parse(xhr.responseText);



                                        window.location.href=`/theraLink/open/${projectNo}/1`;
                                    }
                                });


                                // Get the input file
                                let $inputImages = $form.find('input[name^="images"]');
                                if (!$inputImages.length) {
                                    $inputImages = $form.find('input[name^="photos"]')
                                }



                                // Get the new files names
                                let $fileNames = $('<ul>');
                                for (let file of $inputImages.prop('files')) {
                                    $('<li>', {text: file.name}).appendTo($fileNames);
                                }

                                // Set the new files names
                                $modal.find('#display-new-images').html($fileNames.html());

                                // Get the preloaded inputs
                                let $inputPreloaded = $form.find('input[name^="old"]');
                                if ($inputPreloaded.length) {

                                    // Get the ids
                                    let $preloadedIds = $('<ul>');
                                    for (let iP of $inputPreloaded) {
                                        $('<li>', {text: '#' + iP.value}).appendTo($preloadedIds);
                                    }

                                    // Show the preloadede info and set the list of ids
                                    // $modal.find('#display-preloaded-images').show().html($preloadedIds.html());

                                } else {

                                    // Hide the preloaded info
                                    // $modal.find('#display-preloaded-images').hide();

                                }

                                // Show the modal
                                // $modal.css('visibility', 'visible');

                                // $modal.css('visibility', 'visible');
                            });

                            $('input').on('focus', function () {
                                $(this).parent().find('label').addClass('active');
                            }).on('blur', function () {
                                if ($(this).val() == '') {
                                    $(this).parent().find('label').removeClass('active');
                                }
                            });

                            let $nav = $('nav'),
                                $header = $('header'),
                                offset = 4 * parseFloat($('body').css('font-size')),
                                scrollTop = $(this).scrollTop();

                            $(window).on('scroll', function () {
                                scrollTop = $(this).scrollTop();
                                setNav();
                            });

                            function setNav() {
                                if (scrollTop > $header.outerHeight()) {
                                    $nav.css({position: 'fixed', 'top': offset});
                                } else {
                                    $nav.css({position: '', 'top': ''});
                                }
                            }
                        });

                    })

                }

                console.log('순서체크2')




            })




    })
})

$sendingMessage.addEventListener('click',e=>{

    console.log('메세지 보낼거냐')
    if($inputMessage.value){
        console.log('인풋값이 있네');
        const theraNumber = $sendingMessage.value;
        sendingMessage(theraNumber);
    }
})

function sendingMessage(theraLinkNo){



            console.log("theraLinkNo 이 안넘오오나"+theraLinkNo)
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
                    makeChatting(data,theraLinkNo);

                });

            $inputMessage.value='';






}

function makeChatting(data,theraLinkNo){

    const $theraLinkTitle = document.getElementById('theraLinkTitle');
    const $theraLinkContents = document.getElementById('theraLinkContents');
    const $chattingarea = document.getElementById('chattingarea');
    $chattingarea.textContent="";
    const pmCode = data.me;
    $theraLinkTitle.textContent=data.theraTitle;
    $theraLinkContents.textContent=data.theraContents;

    const pictureArea = document.getElementById('picturearea');

    pictureArea.textContent="";

    $sendingMessage.value='';
    $sendingMessage.value = theraLinkNo;
    if(data.theraChatForBlogDTOS!=null) {
        data.theraChatForBlogDTOS.forEach(t => {
            if(t.theraChatStatus==='Y') {
                const date = t.theraChatBoardDate.toString().split("T")
                const day = date[0];
                const time = date[1];
                const $chat = document.createElement('div');


                if (t.pmCode === pmCode) {
                    console.log('나다');


                    $chat.classList.add('chat-message-right', 'pb-4');
                    $chat.innerHTML = `<div>
                                             <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle mr-1" alt="Chris Wood" width="40" height="40">
                                             <div class="text-muted small text-nowrap mt-2">${day}<br>${time}</div>
                                             <input type="checkbox" class="chatDelete" value="${t.theraChatNo}">
                                          </div>
                                          <div class="flex-shrink-1 bg-light rounded py-2 px-3 mr-3">
                                              <div class="font-weight-bold mb-1" style="font-weight: bolder;">You</div>
                                                  ${t.theraChatContent}
                                          </div>`


                } else {
                    console.log('나 아니다');
                    const date = t.theraChatBoardDate.toString().split("T")
                    const day = date[0];
                    const time = date[1];


                    $chat.classList.add('chat-message-left', 'pb-4');
                    $chat.innerHTML = `<div>
                                            <img src="https://bootdey.com/img/Content/avatar/avatar3.png" class="rounded-circle mr-1" alt="Sharon Lessman" width="40" height="40">
                                             <div class="text-muted small text-nowrap mt-2">${day}<br>${time}</div>
                                         </div>
                                         <div class="flex-shrink-1 bg-light rounded py-2 px-3 ml-3">
                                           <div class="font-weight-bold mb-1">${t.name}</div>
                                                ${t.theraChatContent}
                                         </div>`


                }
                $chattingarea.appendChild($chat);
            }
        })




    }
    if(data.theraLinkPhotoDTOS[0].theralinkSavedName!=null){
        console.log('들어 왔나');

            data.theraLinkPhotoDTOS.forEach(p=>{

                console.log('하나라도 있으면 들어와야')

                const $div = document.createElement('div');
                $div.classList.add('carousel-item','active');
                const $img = document.createElement('img');
                $img.classList.add('d-block','w-100');
                $img.src=`/static/common/postimg/${p.theralinkSavedName}`;
                $div.appendChild($img)

                pictureArea.appendChild($div);
            })








            // pictureArea.insertAdjacentHTML('afterend',buttonHtml)

    }
    // if(data.theraLinkPhotoDTOS!=null){
    //     const pictureArea = document.getElementById('pictureArea');
    //     const arrowArea = document.getElementById('arrowArea');
    //     for(let i =0; i<data.theraLinkPhotoDTOS.size;i++){
    //         arrowArea.insertAdjacentHTML('afterend',`<button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="${i}"
    //                                                     class="active" aria-current="true" aria-label="Slide ${i+1}"></button>`);
    //
    //     }
    //     pictureArea.appendChild(arrowArea);
    //
    //     const innerPicture = document.getElementById('innerPicture');
    //     data.theraLinkPhotoDTOS.forEach(p=>{
    //
    //         innerPicture.insertAdjacentHTML('afterend',`<div class="carousel-item active" data-bs-interval="10000" style="max-height: 40vh;">
    //                                                 <img th:src="|/static/common/postimg/${p.theralinkSavedName}|" class="d-block w-100" alt="...">
    //                                             </div>`)
    //     })
    //
    //     pictureArea.appendChild(innerPicture);
    //     const buttonHtml = `<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
    //     <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    //     <span class="visually-hidden">Previous</span>
    // </button>
    // <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
    //     <span class="carousel-control-next-icon" aria-hidden="true"></span>
    //     <span class="visually-hidden">Next</span>
    // </button>`
    //     pictureArea.insertAdjacentHTML('afterend',buttonHtml)
    // }

    $chattingarea.scrollTop=$chattingarea.scrollHeight;





}


const $chatDeleteButton = document.getElementById('chatDeleteButton');

$chatDeleteButton.addEventListener('click',e=>{
    const chatDelete = document.querySelectorAll('.chatDelete');
    const param = [];
    chatDelete.forEach(d=>{
        if(d.checked){
            param.push(d.value);
        }
    })

    if(param.length>0) {

        const theraNum = $chatDeleteButton.value;
        console.log(param);

        fetch("/theraLink/deleteChating", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                theraNum: theraNum,
                deleteNum: param
            })
        }).then(res => res.json())
            .then(data => {
                console.table(data);
                makeChatting(data, theraNum)
            })
    }
})

const createTheraLink = document.getElementById('createTheraLink');

if(createTheraLink) {
    createTheraLink.addEventListener('click', e => {
        const title = document.getElementById('title');
        title.value = "";
        const contents = document.getElementById('TheraLink-contents');
        contents.value = "";

        const imaging = document.getElementById('imaging');

    })
}