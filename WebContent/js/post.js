$(function(){
    showEditBtn();
    $('#editPost').click(function(){
        editPost();
    });

    $('.close-bottom-edit-row').click(function(){
        $('.bottom-float-edit').hide();
    })
})

function editPost(){
    var postId = $('#postId').val();
    window.location.href = 'edit?id=' + postId;
    window.event.returnValue = false;
}

function showEditBtn(){
    var postId = $('#postId').val();
    $.get('showEditBtn',{postId: postId},function(result){
        if(result.state == 'same'){
            $('.bottom-float-edit').show();
        }
    })
}
