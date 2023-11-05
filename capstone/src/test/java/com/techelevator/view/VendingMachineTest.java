package com.techelevator.view;

import org.junit.Test;
import org.junit.Assert;

public class VendingMachineTest {
    @Test
    public void getChangeTest() {

        //Arrange
        VendingMachine vm = new VendingMachine();
        vm.setBalance(1.00);

        //Act
        int[] result = vm.getTheCoins();

        //Assert
        int[] expected = {4, 0, 0};


    }
}
