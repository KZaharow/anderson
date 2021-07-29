*Вопросы:*  
---   
####Как сравниваются элементы коллекций?  
Для сравнения элементов коллекций используется метод equals() и hashcode();
Эти методы унаследованы от класса Object.
Необходимо у себя переопределять методы equals() и hashcode().
Тогда два объекта эквивалентны если хэш коды этих объектов равны.  

####Почему Мар не относиться к Collection?
Разное смысловое предназначение, Collection расширяется до списков и множеств объектов, Мар хранит пары ключ-значение.
Например, разная реализация и название методов:  
добавление\доступ\удаление эл. по индексу:    
- Collection: add(), get(), set(), remove();
- Map: put(K,V), V=get(K), remove(K);
Некоторые методы у них одинаково называются и схоже работают,size(). 

####Что такое итератор и как он работает в коллекциях?
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

####Что будет если объект, который выступал в качестве ключа в структуре MAP поменяется?  
>Note: great care must be exercised if mutable objects are used as map keys. 
>The behavior of a map is not specified if the value of an object is changed in a manner that affects 
>equals comparisons while the object is a key in the map. A special case of this prohibition is that it 
>is not permissible for a map to contain itself as a key.

т.е. необходимо использовать в качестве ключа неизменяемые объекты, я в своих проектах всегда предпочитал
использовать String. Имутабельно, и в пуле лежит.
 
####Как перебрать все значения HashMap?  
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
        
####Разница между Iterable и Iterator.        
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
 
####Что будет если вызвать Iterator.next()  
E next() returns the next element in the iteration.  
Throws:  
    NoSuchElementException - if the iteration has no more elements
    
####Что будет если добавить еще один элемент в коллекцию во время работы итератора  
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

*Exceptions*  
---
####1. Дайте определение понятию “исключение”  
>An edu.anderson.zaharov.spring_annotation.exception is an event that occurs during the execution of a program that disrupts the normal flow of instructions.

####2. Какова иерархия исключений.  
>https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html  

####3. Можно/нужно ли обрабатывать ошибки jvm?
Перехватывать можно, java это не запрещает, но такое исключение говорит о серьезных ошибках в программе, так что oracle говорит что лучше разобраться с кодом программы / аппартаной частью ПК чем обрабатывать данный вид ошибок   

####4. Какие существуют способы обработки исключений?
>try catch
>try catch finally 
>try-with-resources 
>trows
>trow

####5. О чем говорит ключевое слово throws?
>Чтобы указать, что метод может выбрасывать исключение необходимо использовать ключевое слово throws в конце объявления
> метода. Ключевое слово throws объявляется после имени метода и списка аргументов и перед фигурной скобкой, которая 
>определяет область действия метода.  
>
####6. В чем особенность блока finally? Всегда ли он исполняется?
>. Блок finally выполняется всегда. Этот блок гарантированно выполняется даже в случае непредвиденного исключения. 
>Система времени выполнения всегда выполняет код внутри finally независимо от того, что происходит внутри try блока. 
>Finally является ключевым инструментом для предотвращения утечки ресурсов и восстановления приложения.
>
####7. Может ли не быть ни одного блока catch при отлавливании исключений?
> Catch может отсутствовать
Блок catch является обработчиком исключений. Он обрабатывает тип исключения, которое указано его аргументом. Catch содержит код, который выполняется, если и когда обработчик исключений вызывается.

####8. Могли бы вы придумать ситуацию, когда блок finally не будет выполнен?  
`    
    try {
                System.exit(1);
            } catch (Exception e){
            }`
           

####9. Может ли один блок catch отлавливать несколько исключений (с одной и разных веток наследований)?  
>Любое количество. https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html  

####10. Что вы знаете об обрабатываемых и не обрабатываемых (checked/unchecked) исключениях?  
>*Проверяемые исключения (Checked)*– это исключительные ситуации, которые хорошо написанное приложение должно ожидать и восстанавливать. Проверенные исключения подпадают под требования Catch or Specify.  
>*Ошибки (Errors*) – это исключительные ситуации, внешние по отношению к приложению, которые приложение не может предвидеть или восстанавливать. Ошибки не подпадают под требования Catch or Specify.    
>Источник. https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html

####11. В чем особенность RuntimeException?
>*Исключения во время выполнения (RuntimeException)* – это исключительные ситуации, которые являются внутренними для приложения, и которые приложение обычно не может ожидать или восстанавливать. Они обычно указывают на программные ошибки, такие как логические ошибки или неправильное использование API. Исключения времени выполнения не подпадают под требования Catch or Specify. Приложение может перехватить этот вид исключения, но, вероятно, имеет смысл устранить ошибку, вызвавшую возникновение исключения.
>  
####12. Как написать собственное (“пользовательское”) исключение? Какими мотивами вы будете руководствоваться при выборе типа исключения: checked/unchecked?

0. Uncheked не используем
1. Создать свой класс заканчивающийся на Exception
2. Расширить класс от Exception  


    import lombok.RequiredArgsConstructor;
    
    @RequiredArgsConstructor
    public class CustomArrayException extends Exception {
    
        private final String msg;
    }  
    
    
####13. Какой оператор позволяет принудительно выбросить исключение?
throw

####14. Есть ли дополнительные условия к методу, который потенциально может выбросить исключение?  
>Чтобы указать, что метод может выбрасывать исключение необходимо использовать ключевое слово throws в конце объявления метода. Ключевое слово throws объявляется после имени метода и списка аргументов и перед фигурной скобкой, которая определяет область действия метода.
> https://docs.oracle.com/javase/tutorial/essential/exceptions/declaring.html

####15. Может ли метод main выбросить исключение во вне и если да, то где будет происходить обработка данного исключения?
Может, исключение передастся в jvm/

####16. Если оператор return содержится и в блоке catch и в finally, какой из них “главнее”?
Вернется из блока finally.

####17. Что вы знаете о OutOfMemoryError?
>OutOfMemoryError выбрасывается, когда виртуальная машина Java не может выделить (разместить) объект из-за нехватки памяти, а сборщик мусора не может высвободить ещё.

####18. Что вы знаете о SQLException? К какому типу checked или unchecked оно относится, почему?
>SQLException предоставляет информацию об ошибках доступа к базе данных или других ошибках связанных с работой с базами данных.
>SQLException относится к checked исключениям  
>
####19. Что такое Error? В каком случае используется Error. Приведите пример Error’а.
>Ошибки (Errors) представляют собой более серьёзные проблемы, которые, согласно спецификации Java, 
>не следует пытаться обрабатывать в собственной программе, поскольку они связаны с проблемами уровня JVM. 
>Например, исключения такого рода возникают, если закончилась память, доступная виртуальной машине.
>AnnotationFormatError, AssertionError, AWTError, CoderMalfunctionError, FactoryConfigurationError, FactoryConfigurationError, IOError, LinkageError, SchemaFactoryConfigurationError, ServiceConfigurationError, ThreadDeath, TransformerFactoryConfigurationError, VirtualMachineError

####20. Какая конструкция используется в Java для обработки исключений?
>try catch
>try catch finally 
>try-with-resources 

####21. Предположим, есть блок try-finally. В блоке try возникло исключение и выполнение переместилось в блок finally. В блоке finally тоже возникло исключение. Какое из двух исключений “выпадет” из блока try-finally? Что случится со вторым исключением?  
    public static void main(String[] args) throws NullPointerException {
    
            try {
                int i = 1 / 0;
            } finally {
                try {
    
                } finally {
                    throw new NullPointerException();
                }
            }
        }
        
        > Task :Main.main() FAILED
        Exception in thread "main" java.lang.NullPointerException
        	at edu.anderson.zaharov.Main.main(Main.java:13)  
        	
        	

####22. Предположим, есть метод, который может выбросить IOException и FileNotFoundException в какой последовательности должны идти блоки catch? Сколько блоков catch будет выполнено?

FileNotFoundException extends IOException поэтому сначала обрабатываем его, а затем IOException