$(function(){
    showEditBtn();
    $('#editPost').click(function(){
        editPost();
    });

    $('.close-bottom-edit-row').click(function(){
        $('.bottom-float-edit').hide();
    })
    
    $('#likePost').click(function(){
    	likePost();
    });
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
    });
}

function likePost(){
	var postId = $('#postId').val();
    $.get('likePost',{postId: postId},function(result){
        if(result.like){
        	$('#likePost').addClass('liked');
        	$('#likePost').html('已喜欢');
        }else{
        	$('#likePost').removeClass('liked');
        	$('#likePost').html('喜欢');
        }
    });
}
