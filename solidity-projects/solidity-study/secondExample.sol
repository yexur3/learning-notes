// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract Zoo {
    struct Animal{
        string name;
        int age;
    }

    Animal public animal1 = Animal("Geraffe", 25);
    Animal public animal2 = Animal("Lion", 22);
    Animal public animal3 = Animal("Krot", 2);

    Animal[] public listOfAnimal;


    function addAnimal(string memory _name, int age) public {
        listOfAnimal.push(animal1);
        listOfAnimal.push(animal2);
        listOfAnimal.push(animal3);

        listOfAnimal.push(Animal(_name, age));
    }
}