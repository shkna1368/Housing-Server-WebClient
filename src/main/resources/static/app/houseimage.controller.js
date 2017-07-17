/**
 * Created by dan.geabunea on 3/29/2016.
 */
(function () {
    'use strict';

    var app=angular.module('app')

                app.controller('HouseImagesController', HouseImagesController);

    HouseImagesController.$inject = ['$location','$http'];
    app.config(function($locationProvider) {
        $locationProvider.html5Mode(true);
    });
    function HouseImagesController($location,$http) {
        var vm = this;

        vm.houseImages = [];
        vm.getAllhouseImage = getAllImage;
       // vm.getImage = getImage;

        init();



        function init( ){

            alert ("1="+ $location.search.houseId)
            alert ("2="+   $location.search['houseId'])
            alert ("3="+  $location.search()['houseId'])



            var ids=  $location.search()['houseId'];
            alert ("location= "+$location.absUrl())
            alert ("ids from url"+ids)
            alert ("path from url"+$location.path())

            getAllImage(ids);
        }

        function getAllImage(id){
            alert ("getAll"+id)

            var url = "/v1/findAllHouseImage/"+id;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.houseImages = response.data;
            });
        }

       /* function getImage(counter,imageId){
            var url = "/returnImage/"+counter+'/'+imageId;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.bookings = response.data;
            });
        }*/


    }
})();
