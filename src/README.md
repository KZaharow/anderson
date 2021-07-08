**Вопросы:**  
---   
###Как сравниваются элементы коллекций?  
Для сравнения элементов коллекций используется метод equals() и hashcode();
Эти методы унаследованы от класса Object.
Необходимо у себя переопределять методы equals() и hashcode().
Тогда два объекта эквивалентны если хэш коды этих объектов равны.  

###Почему Мар не относиться к Collection?
Разное смысловое предназначение, Collection расширяется до списков и множеств объектов, Мар хранит пары ключ-значение.
Например, разная реализация и название методов:  
добавление\доступ\удаление эл. по индексу:    
- Collection: add(), get(), set(), remove();
- Map: put(K,V), V=get(K), remove(K);
Некоторые методы у них одинаково называются и схоже работают,size(). 

###Что такое итератор и как он работает в коллекциях?
iterator() метод интерфейса Collection.    
iterator() возвращает итератор - то есть объект, реализующий интерфейс Iterator.  
Интерфейс Iterator имеет следующее определение:
    
    public interface Iterator <E>{
         
        E next();
        boolean hasNext();
        void remove();
    }
	

Реализация интерфейса предполагает, что с помощью вызова метода next() можно получить следующий 
элемент. С помощью метода hasNext() можно узнать, есть ли следующий элемент, и не достигнут ли 
конец коллекции. И если элементы еще имеются, то hasNext() вернет значение true. Метод hasNext() 
следует вызывать перед методом next(), так как при достижении конца коллекции метод next() 
выбрасывает исключение NoSuchElementException. И метод remove() удаляет текущий элемент, 
который был получен последним вызовом next().

###Что будет если объект, который выступал в качестве ключа в структуре MAP поменяется?  
>Note: great care must be exercised if mutable objects are used as map keys. 
>The behavior of a map is not specified if the value of an object is changed in a manner that affects 
>equals comparisons while the object is a key in the map. A special case of this prohibition is that it 
>is not permissible for a map to contain itself as a key.

т.е. необходимо использовать в качестве ключа неизменяемые объекты, я в своих проектах всегда предпочитал
использовать String. Имутабельно, и в пуле лежит.
 
###Как перебрать все значения HashMap?  
Несколько способов:

    public static void main(String[] args) {
    
            HashMap<String, String> map = new HashMap<>();
            map.put("k1", "red");
            map.put("k2", "black");
            //1
            Set<Map.Entry<String, String>> setEntries = map.entrySet();
            Stream<Map.Entry<String, String>> entriesStream = setEntries.stream();
            entriesStream.forEach((e)-> System.out.println(e.getKey() + "=" + e.getValue()));
            //2
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
            //3
            Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
            //4
            for (String key : map.keySet()) {
                System.out.println(key + "=" +  map.get(key));
            }
        }  
        
###Разница между Iterable и Iterator.        
**Iterable** имеет один метод, который возвращает Iterator. Реализация этого интерфейса позволяет объекту использовать 
оператор "foreach".   

    public interface Iterable<T>  
    {
        Iterator<T> iterator();
    }  
**Iterator** используя метод hasNext() проверяет наличие следующего элемента и позволяет перейти к следующему 
элементу (если есть) с помощью next(). Кроме того имеет метод void remove(). Дословно:
>Removes from the underlying collection the last element returned by this iterator (optional operation). 
This method can be called only once per call to next(). The behavior of an iterator is unspecified if the underlying 
collection is modified while the iteration is in progress in any way other than by calling this method.

    public interface Iterator<E>
    {
        boolean hasNext();
        E next();
        void remove();
    }
 
###Что будет если вызвать Iterator.next()  
E next() returns the next element in the iteration.  
Throws:  
    NoSuchElementException - if the iteration has no more elements
    
###Что будет если добавить еще один элемент в коллекцию во время работы итератора  
Будет выброшена ошибка java.util.ConcurrentModificationException.  
Пример:
    
    package com.anderson.trainy;
    
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Iterator;
    import java.util.List;
    
    public class Main {
    
        public static void main(String[] args) {
    
            List<Integer> list = new ArrayList<>(Arrays.asList(1,2));
            Iterator iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
                list.add(3);
            }
        }
    }  
    
 
> Task :Main.main() FAILED
1
Exception in thread "main" 
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at com.anderson.trainy.Main.main(Main.java:15)
`