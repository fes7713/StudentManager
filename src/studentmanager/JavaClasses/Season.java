/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager.JavaClasses;

/**
 *
 * @author fes77
 */
public enum Season {
    SPRING,
    SUMMER,
    FALL;

    @Override
    public String toString() {
        switch (this) {
            case SPRING:
                return "Spring";
            case SUMMER:
                return "Summer";
            case FALL:
                return "Fall";
            default:
                throw new IllegalArgumentException();
        }
    }
}
