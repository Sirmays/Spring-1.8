angular.module('market-front', []).controller('appController', function ($scope, $http){
    const contextPath = 'http://localhost:8189/market/';


     $scope.loadProducts = function (){
         $http.get(contextPath + 'products')
             .then(function (response) {
                 console.log(response);
                 $scope.products = response.data;
             });
        }

     $scope.deleteProduct=function(product){
         $http.get(contextPath + 'products/delete/'+product.id);
        }


    $scope.loadProducts();


});