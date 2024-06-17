# 99클럽 코테 스터디 29일차 TIL 


24.06.17 
스트림을 처음으로 사용해보았다!

```
You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.

 

Example 1:

Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
Output: 1
Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
Example 2:

Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
Output: 2
Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.

```

```
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int i = getIndex(ruleKey);

        Long count = items.stream()
        .map(l -> l.get(i))
        .filter(s -> s.equals(ruleValue))
        .count();

        int answer = count.intValue();

        return answer;

    }

    public int getIndex(String ruleKey){
        return ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
    }

}
```

## 문제분석
List<List<String>> 와 같이 List안에 List가 담겨있다. 그래서 stream을 써봐야겠다는 생각이 들었다. 

최대한 if문을 피하고 싶어서 getIndex 메서드로 분리했다.
근데 코드를 다시보니 굳이 메서드로 분리할 필요가 없었던 것 같다..! 

## TIL
- 컬렉션의 최고 조상인 Collection에 stream()이 정의되어 있습니다.
그렇기 때문에 Collection의 자손인 List와 Set을 구현한 컬렉션 클래스들은 모두 아래 메서드로 스트림을 생성할 수 있습니다.

<img width="855" alt="image" src="https://github.com/jkjkh1318/JavaLanguage/assets/38885241/f409fdcc-1d77-4310-9aa8-221e42b7d0ef">

```
List를 스트림으로 생성하는 코드는 아래와 같습니다.
Stream<Integer> intStream = list.stream(); // list를 소스로 하는 컬렉션 생성
```

=> Collection에 stream() 메서드가 있기 때문에, Collection을 상속받은 컬렉션들은 stream() 메서드로 스트림을 생성할 수 있는거구나.!

- 스트림은 중간연산, 최종연산으로 나누어진다.
중간 연산 : Stream을 반환하는 연산.   
최종 연산 : 연산 결과가 스트림이 아닌 연산. 스트림의 요소를 소모하므로 단 한번만 가능하다.

- stream 연산의 종류가 매우 많다.. 
많이 사용되는 것 (map, filter)이라도 천천히 익혀봐야겠다.

+)스트림을 사용하면 좋은 이유   
데이터 소스를 추상화하여 다른 데이터 소스라도 같은 방식으로 사용할 수 있게 도와준다.

<img width="792" alt="image" src="https://github.com/jkjkh1318/JavaLanguage/assets/38885241/27b8ba53-ff87-4bc5-b479-562d01d6bd85">


스트림 공부 출처: https://hstory0208.tistory.com/entry/Java자바-Stream스트림이란 [< Hyun / Log >:티스토리]


#99클럽 #코딩테스트 준비 #개발자 취업 #항해99 #TIL



