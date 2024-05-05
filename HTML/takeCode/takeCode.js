const $pmCode = document.getElementById('pmCode');
const $empNo = document.getElementById('empNo');
const $pm = document.getElementById('pm');
const $em = document.getElementById('em');
const $next = document.getElementById('nextPage');
let check =[false,false];
$pmCode.addEventListener('input',function(){
    const value = $pmCode.value;
    const isValid =  /^(d|t)\d{3}$/.test(value);
    if(!isValid){
        $pm.style.display='block';
        check[0]=false;
    }
    else{
        $pm.style.display='none';
        check[0]=true;
    }
    checking();
})

$empNo.addEventListener('input',function(){
    const value = $empNo.value;
    const isValid =  /^\d{4}$/.test(value);
    if(!isValid){
        $em.style.display='block';
        check[1]=false;
    }
    else{
        $em.style.display='none';
        check[1]=true;
    }
    checking();
})

function checking(){
    const $next = document.getElementById('nextPage');
    if(check.every(agree=>agree)){
        $next.style.pointerEvents='auto';
        $next.style.opacity=1;
    }
    else{
        $next.style.pointerEvents='none';
        $next.style.opacity=0.55;
    }
};