$(document).ready(function () {

    var baseUrl = 'http://localhost:8080/GenerateData/api/data/';

    $("#go").on('click', function () {

        var amount = $("#num").val();
        var type = $("#type").val();

        generateData(amount, type);
    });


    function generateData(amount, type) {

        $("#persons").empty();

        $.getJSON(baseUrl + amount + '/' + type, function (res) {

            res.forEach(function (entry) {
                append(entry);
            });

        });
    }


    function append(person) {

        var html = "<tr>";

        if (person.name !== undefined) {
            html += "<td>" + person.name + "</td>";
        }

        if (person.surname !== undefined) {
            html += "<td>" + person.surname + "</td>";
        }

        if (person.address !== undefined) {
            html += "<td>" + person.address + "</td>";
        }

        if (person.city !== undefined) {
            html += "<td>" + person.city + "</td>";
        }

        html += "</tr>";

        $("#persons").append(html);
    }

});
