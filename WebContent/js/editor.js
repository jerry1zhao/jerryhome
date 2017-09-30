$(function() {
    inputBoxBlur();
    initFileUpload();
    $("input[name='title']").focus();

    var postEditor = editormd("postEditor", {
        width : "100%",
        height : 640,
        syncScrolling : "single",
        path : "../editormd/lib/",
        saveHTMLToTextarea : true,
        imageUpload : true,
        autoFocus: false,
        imageFormats : ["jpg", "jpeg", "gif", "png"],
        imageUploadURL : "uploadContentImage",
        toolbarIcons : function() {
            // Or return editormd.toolbarModes[name]; // full, simple, mini
            // Using "||" set icons align right.
            return ["undo", "redo", "|",
                    "bold" ,"italic", "quote", "|",
                    "h1", "h2", "h3", "h4", "h5", "h6", "|",
                    "list-ul", "list-ol", "hr", "|",
                    "link", "reference-link", "image", "code", "code-block", "table", "pagebreak", "|",
                    "goto-line", "watch", "preview", "fullscreen", "clear", "search", "|",
                    "help"]
        },
        onfullscreen : function() {
//			$('#postInfo').removeClass('collapse in').addClass('collapse');
            $('.navbar').hide();
//			togetherWithPageInfo();
        },
        onfullscreenExit : function () {
            $('.navbar').show();
        }
    });

    $("#commitPost").click(function(){
        var markdownContent = postEditor.getMarkdown();
        var HTMLContent = postEditor.getHTML();
        commitPost(markdownContent, HTMLContent);
    });
    
    $("#updatePost").click(function(){
        var markdownContent = postEditor.getMarkdown();
        var HTMLContent = postEditor.getHTML();
        commitPost(markdownContent, HTMLContent, true);
    });
    

    $('#postInfo').offCanvas('open');



    //	$("#postImage").on('fileuploaderror', function(event, data, previewId, index)
    //	{
    //	var form = data.form, files = data.files, extra = data.extra,
    //	response = data.response, reader = data.reader;
    //	console.log(data);
    //	console.log('File upload error');
    //	});

    //	$("#postImage").on('fileerror', function(event, data) {
    //	console.log(data.id);
    //	console.log(data.index);
    //	console.log(data.file);
    //	console.log(data.reader);
    //	console.log(data.files);
    //	});

    //	$("#postImage").on('fileuploaded', function(event, data, previewId, index) {
    //	var form = data.form, files = data.files, extra = data.extra,
    //	response = data.response, reader = data.reader;
    //	console.log('File uploaded triggered');
    //	});
});


function initFileUpload() {
    $("#postImage").fileinput({
        language : 'zh',
        fileTypeSettings : [ "image" ],
        allowedPreviewTypes : [ 'image' ],
        allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
        maxFileSize : 2048,
        maxFileCount : 1,
        uploadAsync : false,
        showCaption : false,
        dropZoneEnabled : false,
        showUpload : false,
        fileActionSettings: {
            showRemove: false,
            showUpload: false,
            showZoom: false,
            showDrag: false
        }
    });
}

function inputBoxBlur(){
    $('.form-input').each(function(){
        $(this).blur(function(){
            verify($(this));
        });
    })
}

function checkPost(){
    var checkResult = true;
    var resultMap = new Array();
    $('.form-input').each(function(){
        var result = verify($(this));
        resultMap.push(result);
    });
    for(var result in resultMap){
        if(resultMap[result] == false){
            checkResult = false;
            return checkResult;
        }
    }
    return checkResult;
}

function verify(inputbox){
    var inputValue = inputbox.val();
    var inputGroup = inputbox.closest('.input-group');
    var alertDiv = inputGroup.find('.post-alert-danger');
    if(inputValue == ''||$.trim(inputValue) == ''){
        if(alertDiv.length == 0 || alertDiv.html() == ""){
            alertDiv = $('<div class="post-alert-danger">请在文本框中正确输入内容</div>').appendTo(inputGroup);
        }
        alertDiv.show();
        $('#postInfo').offCanvas('open');
        return false;
    } else{
        alertDiv.hide();
        return true;
    }
}

function checkPostImage(){
    if ($('#postImage').fileinput("getFilesCount") <= 0) {
        var isChecked = $('#noPostImage').is(':checked');
        if(isChecked){
            return true;
        } else {
            $('#postImageModal').modal('open');
            $('#postInfo').offCanvas('open');
            return false;
        }
    }
    return true;
}

//function checkPostImage(){
//if ($('#postImage').fileinput("getFilesCount") <= 0) {
//if(confirm("是否不上传主图片?!")){
//return true;
//} else {
//$('#postInfo').offCanvas('open');
//return false;
//}
//}
//}

function checkEditor(markdownContent, HTMLContent){
    if(markdownContent.length == 0 || HTMLContent.length == 0 || $.trim(markdownContent) == ''){
        $('#postContentModal').modal('open');

        return false;
    }
    return true;
}

function commitPost(markdownContent, HTMLContent,isUpdate) {
    if (checkPost() && checkPostImage()
            && checkEditor(markdownContent, HTMLContent)) {
    	if(isUpdate){
    		$("#postForm").attr('action', 'updatePost');
    	} else{
    		$("#postForm").attr('action', 'savePost');
    	}
        $("#postForm").ajaxSubmit({
            success : function(data) {
                //$('#postImage').fileinput('upload');
                window.location.href = data.postId;
                window.event.returnValue = false;
            }
        });
        return false;
    }
}









