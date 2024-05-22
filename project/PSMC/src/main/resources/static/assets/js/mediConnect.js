function toggleDeleteButton() {
    var checkboxes = document.getElementsByName("postCheckbox");
    var deleteButton = document.querySelector("#delete-btn button");
    var atLeastOneChecked = false;

    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            atLeastOneChecked = true;
            deleteButton.style.display='block';
            break;
        }
    }

    if (atLeastOneChecked) {
        deleteButton.style.display='block';
    } else {
        deleteButton.style.display='none';
    }
}

function deleteSelectedPosts() {
    var checkboxes = document.getElementsByName("postCheckbox");
    var rowsToDelete = [];

    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            rowsToDelete.push(checkboxes[i].parentNode.parentNode);
        }
    }

    for (var i = 0; i < rowsToDelete.length; i++) {
        rowsToDelete[i].parentNode.removeChild(rowsToDelete[i]);
    }
}

// 모달 객체 가져오기
var modal = document.getElementById("myModal");

// 닫기 버튼 가져오기
var span = document.getElementsByClassName("close")[0];

// 작성하기 버튼 가져오기
var btn = document.getElementsByClassName("btn btn-light")[0];

// 모달 열기
btn.onclick = function() {
    modal.style.display = "block";
}

// 모달 닫기
span.onclick = function() {
    modal.style.display = "none";
}

// 모달 영역 외의 영역 클릭 시 닫기
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}