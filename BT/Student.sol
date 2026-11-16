Write a program in solidity to create Student data. Use the following constructs:
 Structures
 Arrays
 Fallback
Deploy this as smart contract on Ethereum and Observe the transaction fee and Gas values


// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract Student{

    struct Studentdata{
        uint rollNo;
        string firstName;
        string lastName;
        uint marks;
    }

    Studentdata [] public studentrecords;

    address public owner=msg.sender;

    modifier  onlyOwner(){
        require(msg.sender==owner,"Only owner can make modification");
        _;
    }

    //add student

    function addStudent(uint rn, string memory fn,string memory ln,uint marks) public onlyOwner{
        studentrecords.push(Studentdata(rn,fn,ln,marks));
    }

    //view student record

    function viewStudent(uint index) public view returns(Studentdata memory) {
    return studentrecords[index];
}


    //add bonus marks

    function addBonusmarks(uint rollNo, uint bonusMarks) public onlyOwner {
        studentrecords[rollNo].marks+=bonusMarks;

    }

    // total no of students

    function studentCount() public view returns(uint){
        return studentrecords.length;
    }

    receive() external payable { }
    fallback () external payable {}
}