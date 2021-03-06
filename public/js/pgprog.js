/**
 * sends a request a for the main menu
 */
function generateMenu() {
    var firstSelected = false;
    $.ajax({
        url:  '/views/list',
        type: 'GET',
        success: function (data) {
            $.each(data, function (index, item) {
                if (!firstSelected) {
                    firstSelected = true;
                    (getChallenge(item.id))();
                }
                var aTag = createAnchor($('#challengemenu'), item.heading);
                aTag.onclick = getChallenge(item.id);
            });
        }
    });
}

/**
 * Create anchor and add it to a div
 */
function createAnchor(divObject,  linkText) {
    var aTag = document.createElement('a');
    aTag.innerHTML = linkText;
    divObject.append(aTag);
    return aTag;
}

function getChallenge(id) {
    return function () {
        $.ajax({
            url: '/views/challenge/' + id,
            type: 'GET',
            success: function (data) {
                $('#challengeform').load('/' + data.challenge.view, function () {
                    $('#description').html(data.challenge.description);
                    $('#subheader').html(data.challenge.heading);
                    $('#process').click(createChallengeProcessor(id, standardDataLoader));
                });
            },
            error: function () {
                alert("could not configure challenge " + id);
            }

        });

    }
}

function standardDataLoader() {
    return {
        data : JSON.stringify({inputString : $('#inputString').val()})
    };
}

function createChallengeProcessor(id, dataLoader) {
    return function() {
        $.ajax({
            url: '/challenges/' + id,
            type: 'POST',
            data: dataLoader(),
            success: function(data) {
                $('#outputString').html(data.outputString);
            },
            error : function(data) {
                alert("ERROR: " + data.responseJSON.error + ":" + data.responseJSON.message);
            }
        });
    }
}

function createList(sin, listName) {
    var s = $(sin).val();
    var a = s.split(",");

    for (var i = 0; i < a.length; i++) {
        $(listName).append($("<option></option>")
            .attr("value", i)
            .text(a[i])
        );
    }
}

function linkButton(divId, challengeId) {
    $(divId).click(
        createChallengeProcessor(challengeId, function () {
            return {
                data : JSON.stringify({
                    dictonary : $('#dictonary').val(),
                        startword : $('#startword').val(),
                        endword   : $('#endword').val()
                })
            };
        })
    );
 }



