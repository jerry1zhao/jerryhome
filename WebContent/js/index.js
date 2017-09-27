$(function(){
    $('#loadMoerByIndex').click(function(){
        loadMoerByIndex();
    })
})

var nextPage = 2;
function loadMoerByIndex(){
    $.get('showNextPage',{nextPage: nextPage},function(result){
        if(result.posts.length > 0){
            $.each(result.posts, function(index,obj){
                $('.post-list').append(spliceIndexArticle(obj));
            })
            nextPage ++;
            $('#loadMoerByIndex').blur();
        } else {
            $('#loadMoerByIndex').html('没有更多帖子啦');
            $('#loadMoerByIndex').attr('disabled','disabled');
        }
    })
}


function timeStamp2String(time){
    var datetime = new Date();
    var currentYear = datetime.getFullYear();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    //var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    //var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    //var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    //return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
    if(currentYear == year){
    	return month + "月" + date + "日";
    }
    return year + "年" +month + "月" + date + "日";
}

function spliceIndexArticle(obj){
	var articleBlock = "<article class='post'><div class='post-media col-md-12'>";
	if(obj.postImage.length != 0 || obj.postImage != ''){
		articleBlock += "<a href='post/"+obj.id+"'><img class='post-image' src='"+obj.postImage+"'></a></div><div class='post-head'><h3><a href='post/"+obj.id+"'>"+obj.title+"</a></h3></div><div class='post-context'><h5>"+obj.description.substring(0,120)+"</h5></div><footer class='post-footer'><div class='interacts'><span> <img src='images/post/like-icon.png' alt='like'> <span>"+obj.postLikeCount+"</span></span> <span> <img src='images/post/comment-icon.png' alt='comment'> <span>0</span></span></div><div class='sign'><a class='author'><img src='"+obj.createUser.photo+"' class='img-circle user-avatar'>&nbsp;"+obj.createUser.name+"</a><span> 发布了文章 </span><time>"+timeStamp2String(obj.createDate)+"</time></div></footer></article>";
	}else{
		articleBlock += "</div><div class='post-head'><h3><a href='post/"+obj.id+"'>"+obj.title+"</a></h3></div><div class='post-context'><h5>"+obj.description.substring(0,120)+"</h5></div><footer class='post-footer'><div class='interacts'><span> <img src='images/post/like-icon.png' alt='like'> <span>"+obj.postLikeCount+"</span></span> <span> <img src='images/post/comment-icon.png' alt='comment'> <span>0</span></span></div><div class='sign'><a class='author'><img src='"+obj.createUser.photo+"' class='img-circle user-avatar'>&nbsp;"+obj.createUser.name+"</a><span> 发布了文章 </span><time>"+timeStamp2String(obj.createDate)+"</time></div></footer></article>";
	}
	return articleBlock;
}