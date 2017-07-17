/**
 * Created by dan.geabunea on 3/29/2016.
 */
(function () {
    'use strict';

    angular
        .module('app')
        .controller('HousingController', HousingController);

    HousingController.$inject = ['$http'];

    function HousingController($http) {
        var vm = this;

        vm.housing = [];
        vm.getAll = getAll;
        vm.getAffordable = getAffordable;
        vm.deleteBooking = deleteBooking;
        vm.goToHouseImage = goToHouseImage;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/v1/house/getAllHouse";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.housing = response.data;
            });
        }

        function getAffordable(){
            var url = "/bookings/affordable/" + 100;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.bookings = response.data;
            });
        }

        function deleteBooking(id){
            var url = "/bookings/delete/" + id;
            $http.post(url).then(function(response){
                vm.bookings = response.data;
            });
        }
        function goToHouseImage(id){
            var url = "/v1/findAllHouseImage/" + id;
            $http.get(url).then(function(response){
             //   vm.bookings = response.data;
                alert (response.data)
               // window.location.href="/houseimage?id="+id;
                window.open("/houseimage?houseId="+id, '_blank');
            });
        }
    }
})();
