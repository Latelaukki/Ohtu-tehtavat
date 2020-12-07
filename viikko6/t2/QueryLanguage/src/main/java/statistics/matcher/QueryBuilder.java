
package statistics.matcher;

import java.util.*;

public class QueryBuilder {
    Matcher m;
    ArrayList<Matcher> matches = new ArrayList<>();
    
    public QueryBuilder() {
        m = new All();
    }
    
    public Matcher build() {
        this.m = new And(m);
        return m;
    }
    
    public QueryBuilder playsIn(String team) {
        this.m = new PlaysIn(team);
        
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.m = new HasAtLeast(value, category);
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.m = new HasFewerThan(value, category);
        return this;
    }
    
//    public QueryBuilder not(Matcher matcher) {
//        this.m = new Not(matcher);
//        return this;
//    }
    
//    public Ma and(Matcher...matches) {
//        this.m = new And(matches);
//        return this;
//    }
//    
//    public QueryBuilder or(Matcher... matchers) {
//        this.m = new Or(matchers);
//        return this;
//    }
}
