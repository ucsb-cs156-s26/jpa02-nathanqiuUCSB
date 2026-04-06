package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
public class TeamTest {

    Team team;
    Team other;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");  
        other = new Team("other"); 
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    @Test
    public void equals_same_object(){

        assertEquals(true, team.equals(team));
    }
    @Test 
    public void equals_differentClass(){
        assertEquals(false, team.equals("other"));
    }
    @Test
    public void equals_sameAttributes(){
        Team team1 = new Team("Alpha");
        Team team2 = new Team("Alpha");
        ArrayList<String> members = new ArrayList<>(List.of("Alice", "Bob", "Charlie"));
        team1.setMembers(members);
        team2.setMembers(members);
        assertEquals(true, team1.equals(team2));
    }
    @Test
    public void testEquals_sameName_differentMembers() {
        // Case 3 (T, F): name matches but members differ → false
        Team team1 = new Team("Alpha");
        Team team2 = new Team("Alpha");
        ArrayList<String> members1 = new ArrayList<>(List.of("Alice", "Bob", "Charlie"));
        ArrayList<String> members2= new ArrayList<>(List.of("Alice", "Bob"));
        team1.setMembers(members1);
        team2.setMembers(members2);
        assertEquals(false, team1.equals(team2));
    }
    @Test
    public void testEquals_differentName() { 
        Team team1 = new Team("Alpha");
        Team team2 = new Team("Beta");
        assertEquals(false, team1.equals(team2));
    }
    @Test
    public void test_hashCode(){
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);

    }

}
