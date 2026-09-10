// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract ShopOfBananas {
    mapping (address => bool) buyers;
    uint256 public price = 31 ether; 
    address public owner;
    address public ShopAddress;



    constructor() {
        owner = msg.sender;
        ShopAddress = address(this);

    }

    function addbuyer(address addre) public {
        require(owner == msg.sender, "You are not an owner!");

        buyers[addre] = true;
    }

    function getBalance() public view returns(uint) {
        return ShopAddress.balance;
    }

    function withdrawAll() public {
        require(owner == msg.sender && ShopAddress.balance > 0, "Rejected");

        address payable receiver = payable(msg.sender);

        receiver.transfer(ShopAddress.balance);
    }

    receive() external payable {
        require(buyers[msg.sender] && msg.value <= price, "Rejected");
    }


}