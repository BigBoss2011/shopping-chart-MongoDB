App.controller('dashboardController',['$scope', '$rootScope','$http','$q', function($scope, $rootScope, $http, $q) {
    $scope.validEmail = false;
    $scope.downloadEmail = '';
    $scope.error = false;
    $scope.errorMessage = '';
    $scope.currentCategory = '';
    $scope.newsletter = false;
    $scope.link = '';
    $scope.articleId = '';
    $scope.showAuthorBio = false;
    $scope.authorBio = {};

    setTimeout(function(){
        if (typeof(Storage) !== "undefined" && !sessionStorage.getItem('newsletter')) {
            sessionStorage.setItem("newsletter", true);
            $("#newslettermodal").modal('show');
        }
    }, 90000);

    $scope.subscribe = function(email){
        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if(!email || !regex.test(email)){
            alert("Invalid email.");
            return;
        }
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }
        var data = {};
        data.email = email;
        var url = "subscribe";
        $http.post(url, data, config)
            .then(
                function (response) {
                    $("#newslettermodal").modal('toggle');
                },
                function (errResponse) {
                    if (errResponse.status == -1) {
                        errResponse.status = 408;
                        errResponse.statusText = 'Server Timeout.';
                    }
                    alert(errResponse.status + ':' + errResponse.statusText);
                });
    };
    $scope.downloadSource = function(url) {
        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if($scope.downloadEmail.length > 0 && regex.test($scope.downloadEmail)) {
            if($scope.userName.length > 0) {
                $scope.error = false;
                $scope.validEmail = true;
                var data = {};
                data.email = $scope.downloadEmail; data.name = $scope.userName;
                data.newsLetter = $scope.newsletter;
                var config = {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
                var url = "downloadSource?url=" + url;
                $http.post(url, data, config)
                    .then(
                        function (response) {
                            $scope.link = response.data.link;
                            $scope.error = false;
                            $scope.validEmail = true;
                            $scope.errorMessage = '';
                            $scope.showCloseButton = true;
                        },
                        function (errResponse) {
                            if (errResponse.status == -1) {
                                errResponse.status = 408;
                                errResponse.statusText = 'Server Timeout.';
                            }
                            alert(errResponse.status + ':' + errResponse.statusText);
                            return $q.reject(errResponse);
                        });

            }  else {
                $scope.errorMessage = "Name is required.";
                $scope.error = true;
            }
        }else {
            $scope.errorMessage = "Invalid email.";
            $scope.error = true;
        }
    };

    $scope.fetchAuthorBio = function(articleId){
        var url = "author-bio/" + articleId;
        $http.get(url)
            .then(
                function (response) {
                   $scope.authorBio = response.data;
                   if($scope.authorBio) {
                       $scope.showAuthorBio = true;
                   }
                },
                function (errResponse) {
                    if (errResponse.status == -1) {
                        errResponse.status = 408;
                        errResponse.statusText = 'Server Timeout.';
                    }
                    alert(errResponse.status + ':' + errResponse.statusText);
                });
    };

    $scope.initial = function(sUrl, sTitle, sDesc){
        $scope.sUrl = sUrl;
        $scope.sTitle = sTitle;
        $scope.sDesc = sDesc;
    };

}]);

$(document).ready(function(){
        var imgDefer = document.getElementsByTagName('img');
        for (var i=0; i<imgDefer.length; i++) {
            if(imgDefer[i].getAttribute('data-src')) {
                imgDefer[i].setAttribute('src',imgDefer[i].getAttribute('data-src'));
            } }
    var devglanSecCss = document.createElement('link');
    devglanSecCss.rel = 'stylesheet';
    devglanSecCss.href = '//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css';
    devglanSecCss.type = 'text/css';
    var godefer = document.getElementsByTagName('link')[0];
    godefer.parentNode.insertBefore(devglanSecCss, godefer);

    var head_height = $('#header').height();
    $('.content-container').css('margin-top',head_height);
    var str = $('.post_cat_links a').text();
    if(str.length > 10) str = str.substring(0,59);
    var div_fix = head_height + 20;
    var fixmeTop = $('.google_ad').offset().top;
    $(window).scroll(function(){
        var currentScroll = $(window).scrollTop(); // get current position

        if (currentScroll >= fixmeTop) {           // apply position: fixed if you
            $('.google_ad').css({                      // scroll to that element or below it
                position: 'fixed',
                width:'auto',
                top: div_fix
            });
        } else {                                   // apply position: static
            $('.google_ad').css({                      // if you scroll above it
                position: 'static'
            });
        }
    });

});
