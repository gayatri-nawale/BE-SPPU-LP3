Write a smart contract on a test network, for Bank account of a customer for following
operations:
 Deposit money
 Withdraw Money
 Show balance



pragma solidity ^0.8.20;

contract BankAcc{
    mapping(address=> uint256) public balanceof;

    function deposit() public payable{
        require(msg.value>0,"amount must not be less than zero");
        balanceof[msg.sender]+=msg.value;
    }

    function withdraw(uint256 amount) public{
        require(amount>0,"amount not less than zero");
        require(amount<balanceof[msg.sender],"insufficient balance");

        balanceof[msg.sender]-=amount;

        (bool success,)=payable(msg.sender).call{value:amount}("");
        require(success,"transaction failed");
    }


    function checkbalance()public view returns(uint256){
        return balanceof[msg.sender];
    }
}