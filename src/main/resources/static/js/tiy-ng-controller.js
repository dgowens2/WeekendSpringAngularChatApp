angular.module('TIYAngularChatApp', [])
   .controller('ChatController', function($scope, $http) {

       $scope.getMessages = function() {
           console.log("Retrieving messages...");
//           $scope.name = "JavaScript Master Guru";

           $http.get("http://localhost:8080/history.json")
               .then(
                   function successCallback(response) {
                       console.log("inside the callback function")
                       console.log(response.data);
                       console.log("Adding data to scope");
                       $scope.messages = response.data;
                   },
                   function errorCallback(response) {
                       console.log("Unable to get data");
                   });

           console.log("Done with the promise - waiting for the callback");
       };

       $scope.addMessage = function() {
           console.log("About to add the following message " + JSON.stringify($scope.newMessage));

           $http.post("/addMessage.json", $scope.newMessage) // Post takes two parameters, the url to post to and the payload (SEE @REQUESTBODY in Controller
               .then(
                   function successCallback(response) {
                      console.log("about to add message")
                      console.log(response.data);
                      console.log("Adding data to scope");
                      $scope.messages = response.data;
                   },
                   function errorCallback(response) {
                       console.log("Unable to get data");
                   });
       };

       $scope.newMessage = {};
       console.log("Page loaded.")
   });