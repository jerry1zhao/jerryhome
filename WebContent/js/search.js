$(function(){
    $('#search').click(function(){
        window.location.href = 'searchs?post=' + $('#inputSearch').val();
    });

    $("#inputSearch").keydown(function(event) {
        if (event.keyCode == 13) {
            window.location.href = 'searchs?post=' + $('#inputSearch').val();
        }
    });
})
