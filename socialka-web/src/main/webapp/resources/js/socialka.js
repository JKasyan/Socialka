/**
 * Created by Evgen on 21.06.2015.
 */

//Function for sending proposal be friend
function beFriends(id) {
	$.ajax({
		url : 'add_to_friend.html',
		data : {
			queryId : id
		},
		type : 'GET',
		success : function(data) {
			document.getElementById("be_friends_button").disabled = true;
			$("be_friends_button").val("Request sent");
		}
	});
}

function upDateProposalsBeFriend() {
	$.ajax({
		url : 'get_quant_proposals.html',
		type : 'GET',
		success : function(data) {
			var oldQuantity = $(".notification span").text();
			if (data != oldQuantity && data != "+0")
				$(".notification").append("<span>" + data + "</span>");
		}
	});
}

function formSubmit() {
	document.getElementById("logoutForm").submit();
}


function deleteOrAddFriend(id) {
	var cssFriendId = "#friend_"+id;
	var value = $(cssFriendId+" a").html();
	console.log(value);
	var urlFunction;
	var functionName;
	if(value == "Delete from friends"){
		console.log("Value of link is \"Delete from friends\"");
		urlFunction = "delete_from_friends.html";
		value = "Come back to friend";
	}else{
		console.log("Value of link is \"Come back to friend\"");
		urlFunction = "come_back_friend.html";
		value = "Delete from friends";
	}
	$.ajax({
		url : urlFunction,
		data : {
			idFriend : id
		},
		type : 'GET',
		success : function(data) {
			$(cssFriendId+" a").remove();
			$(cssFriendId).append("<div><a href =\"javascript:deleteOrAddFriend("+id+")\">"+value+"</a></div>");
		}
	});
}
