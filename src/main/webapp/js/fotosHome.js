

function GetFotosHome() {

//debugger;
    $.ajax({
        type: "GET",
        url: "https://www.cyberoficina.com.br/Fotos_Festa/API/getFotos",
        data: {token: "9ember_2020"},
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Access-Control-Allow-Origin': 'https://www.cyberoficina.com.br'

        },
        dataType: "jsonp",
        success: function (result) {
            //debugger;

            var json = JSON.stringify(result);
            json = JSON.parse(json);
            for (var k = 0; k < (json.length); k++) {

                var images = '<a href="#modal' + json[k].id + '" data-toggle="modal" data-target="#modal' + json[k].id + '">' +
                        '<img src="https://www.cyberoficina.com.br' + json[k].path + '" alt="">' +
                        '</a>';


                var modal = '<div id="modal' + json[k].id + '" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog">' +
                        '<div class="modal-dialog modal-lg" role="document">' +
                        '<div class="modal-content">' +
                        '<div class="modal-header">' +
                        '<div class="row">' +
                        '<h1 class="modal-title col-md-10">' + json[k].name + '</h1>' +
                        '<div class="text-muted col-md-10 mt-2 mb-2"><p>' + json[k].message + '</p>' +
                        '</div>' +
                        '</div>' +
                        '<button type="button" class="close" data-dismiss="modal" aria-label="Close">' +
                        '<span aria-hidden="true">&times;</span>' +
                        '</button>' +
                        '</div>' +
                        '<div class="modal-body">' +
                        '<img style="width: 100%; padding: 7px 0;" src="http://www.cyberoficina.com.br' + json[k].path + '" alt="">' +
                        '</div>' +
                        '<div class="modal-footer">' +
                        '<button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>' +
                        '</div>' +
                        '</div>' +
                        '</div>' +
                        '</div>';


                $("#images").append(images);
                $("#modal").append(modal);

//$('.toast').toast({delay: 20000});
//$('.toast').toast('show');

            }
        },
        error: function (response) {
            //debugger;
            console.log('eror ' + response);
        }
    });

}
