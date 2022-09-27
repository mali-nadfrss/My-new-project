/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map =new HashMap<>();
        
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
            
            addrating(map.get(id), id, map);
        
        return ans;
    }
    int ans = 0;
    void addrating(Employee e, int id, Map<Integer, Employee> map){
        if(e == null) return;
        int rating = e.importance;
        for(Integer i : e.subordinates){
            Employee emp = map.get(i);
            addrating(emp, id, map);
            rating += emp.importance;
        }
        e.importance = rating;
        if(id == e.id){
            ans = rating;
        }
        
    }
    
}