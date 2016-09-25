angular.module('TIYAngularChatApp', [])
   .controller('ChatController', function($scope, $http) {

       $scope.getMessages = function() {
           console.log("Retrieving messages...");
//           $scope.user = "JavaScript Master Guru";

           $http.get("http://localhost:8080/history.json")
               .then(
                   function successCallback(response) {
                       console.log("inside the callback function")
                       console.log(response.data);
                       console.log("Adding data to scope");
                       $scope.messages = response.data;
                       console.log("data added after scope.messages")
                   },
                   function errorCallback(response) {
                       console.log("Unable to get data");
                   });

           console.log("Done with the promise - waiting for the callback");
       };

       $scope.addMessage = function() {
           console.log("About to add the following message " + JSON.stringify($scope.newMessage));

           $http.post("/addMessage.json", $scope.newMessage, $scope.newUser)
               .then(
                   function successCallback(response) {
                       console.log("about to add message")
                       console.log(response.data);
                       console.log("Adding data to scope");
                       $scope.messages = response.data;
                       console.log("data added after scope.messages")
//                       $scope.users = response.data;
//                       console.log("added user to user")
                   },
                   function errorCallback(response) {
                       console.log("Unable to get data");
                   });
       };

       $scope.addUser = function() {
          console.log("About to add the following user " + JSON.stringify($scope.newUser));

          $http.post("/addUser.json", $scope.newUser)
              .then(
                  function successCallback(response) {
                     console.log("about to add user")
                     console.log(response.data);
                     console.log("Adding data to scope");
                     $scope.messages = response.data;
                     console.log("added user to messages")
//                     $scope.users = response.data;
//                     console.log("added user to user")

                  },
                  function errorCallback(response) {
                      console.log("Unable to get data");
                  });
      };

       $scope.newMessage = {};
       $scope.newUser = {};
       console.log("Page loaded.")
   });