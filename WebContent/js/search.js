$(function(){
    $('#search').click(function(){
        window.location.href = 'fullTextSearch?text=' + $('#inputSearch').val();
    });

    $("#inputSearch").keydown(function(event) {
        if (event.keyCode == 13) {
            window.location.href = 'fullTextSearch?text=' + $('#inputSearch').val();
        }
    });
})
