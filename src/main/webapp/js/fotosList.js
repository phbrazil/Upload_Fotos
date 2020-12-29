

function GetFotos(current) {

    console.log('searching new images');
    //debugger;
    $.ajax({
        type: "GET",
        url: "https://www.cyberoficina.com.br/Fotos_Festa/API/getFotos",
        data: {token: "9ember_2020"},
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
            //debugger;

            var json = JSON.stringify(result);

            json = JSON.parse(json);

            for (var k = 0; k < (json.length); k++) {

                if (current.includes(json[k].id)) {

                    console.log("already loaded");

                } else {
                    
                    //add new element to current list
                    current.push(json[k].id);
                    

                    var option_name = '<div class="col-lg-8 offset-lg-2"><div class="blog-post bottom_120">' +
                            '<a class="blog-link" href="#">' +
                            '<figure class="bottom_60">' +
                            '<img src="https://www.cyberoficina.com.br' + json[k].path + '" alt="">' +
                            '</figure>' +
                            '</a>' +
                            '<div class="col-lg-10 offset-lg-1 content-outter">' +
                            '<div class="blog-categories bottom_15">' +
                            ' </div>' +
                            '<h2 class="blog-title bottom_15" id="nome">' + json[k].name + '</h2>' +
                            '<p class="blog-text" id="txt">' + json[k].message + '</p>' +
                            '</div>' +
                            '</div>' +
                            '</div>';

                    $("#messages").append(option_name);

                    $('.toast').toast({delay: 20000});
                    $('.toast').toast('show');

                }




            }
        },
        error: function (response) {
            //debugger;
            console.log('eror ' + response);
        }
    });
    
    return current;

}
