$(function(){

    $('#search').click(function(){
        window.location.href = 'searchs?article=' + $('#inputSearch').val();
        window.event.returnValue = false;
    });

    $("#inputSearch").keydown(function(event) {
        if (event.keyCode == 13) {
            window.location.href = 'searchs?article=' + $('#inputSearch').val();
            window.event.returnValue = false;
        }
    });

    $('#loadMoerBySearch').click(function(){
        loadMoerBySearch();
    });

    $('#loadMoerSearchUsers').click(function(){
        loadMoerAuthors();
    })

    $('#searchAuthors').on('show.bs.tab',function(e){
        searchAuthors();
    })

    //write
    $('#writingBtn').click(function(){
        userIsLoggedIn();
    });

    $('#writingWindow').click(function(){
        userIsLoggedIn();
    });
})

function searchAuthors(){
    var searchHeader = decodeURI(location.search);
    $.get('searchUsers',{searchHeader: searchHeader},function(result){
        $('.list-authors').empty();
        nextAuthorsPage = 2;
        if(result.authors.length > 0){
            $('#loadMoerSearchUsers').attr('disabled',false);
            $('#loadMoerSearchUsers').html('加载更多');
            $.each(result.authors, function(index,obj){
                $('.list-authors').append(
                        "<li class='list-group-item'>"+
                        "<a href='#'><img class='list-group-user-img' src='"+obj.photo+"'></a>"+
                        "<h5><a href='#'>"+obj.name+"</a></h5>"+
                    "</li>");
            })
        } else {
            $('.list-authors').append("<h5>噢~没有找到你想要的...</h5>");
            $('#loadMoerSearchUsers').hide();
        }
    })
}

var nextAuthorsPage = 2;
function loadMoerAuthors(){
    var searchHeader = decodeURI(location.search);
    $.get('loadMoerSearchResult',{nextPage: nextAuthorsPage,searchHeader: searchHeader,isSearchAuthors: true},function(result){
        if(result.authors.length > 0){
            $.each(result.authors, function(index,obj){
                $('.list-authors').append(
                        "<li class='list-group-item'>"+
                        "<a href='#'><img class='list-group-user-img' src='"+obj.photo+"'></a>"+
                        "<h5><a href='#'>"+obj.name+"</a></h5>"+
                    "</li>");
            })
            nextAuthorsPage ++;
            $('#loadMoerSearchUsers').blur();
        } else {
            $('#loadMoerSearchUsers').html('没有更多的用户啦');
            $('#loadMoerSearchUsers').attr('disabled','disabled');
        }
    })
}


var nextSearchPage = 2;
function loadMoerBySearch(){
    var searchHeader = decodeURI(location.search);
    $.get('loadMoerSearchResult',{nextPage: nextSearchPage,searchHeader: searchHeader},function(result){
        if(result.nextPageResult.length > 0){
            $.each(result.nextPageResult, function(index,obj){
                $('.posts').append(spliceSearchArticle(obj)
//                        "<article class='post'>"+
//                        "<div class='post-user-card'><div class='sign'><h5><a class='username'> <img src='"+obj.createUser.photo+"' class='img-circle user-avatar'> "+obj.createUser.name+" </a> 发布了文章 - <time>"+timeStamp2String(obj.createDate)+"</time></h5></div></div>"+
//                        "<div class='post-head'><h3><a href='post/"+obj.id+"'>"+obj.title+"</a></h3></div>"+
//                        "<div class='col-md-8'><div class='post-context'><h5>"+obj.description+"</h5></div></div>"+
//                        "<div class='post-media col-md-4'><a href='post/"+obj.id+"'><img class='post-image' src='"+obj.postImage+"'></a></div>"+
//                        "<footer class='post-footer col-md-12'><div class='interacts'><span> <img src='images/post/like-icon.png' alt='like'><span>"+obj.postLikeCount+"</span></span> <span> <img src='images/post/comment-icon.png' alt='comment'> <span>0</span></span></div></footer></article>"
                );
            })
            nextSearchPage ++;
            $('#loadMoerBySearch').blur();
        } else {
            $('#loadMoerBySearch').html('没有更多的帖子啦');
            $('#loadMoerBySearch').attr('disabled','disabled');
        }
    })
}

function userIsLoggedIn(){
    $.get('userIsLoggedIn',function(result){
        if (result){
            window.location.href='post/editor';
            window.event.returnValue = false;
        } else {
            $('#editorModal').modal('open');
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

function spliceSearchArticle(obj){
	var articleBlock = "<article class='post'><div class='post-user-card'><div class='sign'><h5><a class='username'> <img src='"+obj.createUser.photo+"' class='img-circle user-avatar'> "+obj.createUser.name+" </a> 发布了文章 - <time>"+timeStamp2String(obj.createDate)+"</time></h5></div></div><div class='post-head'><h3><a href='post/"+obj.id+"'>"+obj.title+"</a></h3></div><div class='col-md-8'><div class='post-context'><h5>"+obj.description.substring(0,110)+"</h5></div></div><div class='post-media col-md-4'>";
	if(obj.postImage.length != 0 || obj.postImage != ''){
		articleBlock += "<a href='post/"+obj.id+"'><img class='post-image' src='"+obj.postImage+"'></a></div><footer class='post-footer col-md-12'><div class='interacts'><span> <img src='images/post/like-icon.png' alt='like'><span>"+obj.postLikeCount+"</span></span> <span> <img src='images/post/comment-icon.png' alt='comment'> <span>0</span></span></div></footer></article>";
	}else{
		articleBlock += "</div><footer class='post-footer col-md-12'><div class='interacts'><span> <img src='images/post/like-icon.png' alt='like'><span>"+obj.postLikeCount+"</span></span> <span> <img src='images/post/comment-icon.png' alt='comment'> <span>0</span></span></div></footer></article>";
	}
	return articleBlock;
}
