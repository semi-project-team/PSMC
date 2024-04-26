
const $mainbar = document.getElementById('mainbar')

$mainbar.addEventListener(mouseover,e=>{
    console.log('읽힘?')
    alert('마우스 오버 됨?')
    const $title = $mainbar.getElementsByTagNameNS
    $title.forEach(element => {
        e.classlist.remove('hidden')
    });
    
    
})