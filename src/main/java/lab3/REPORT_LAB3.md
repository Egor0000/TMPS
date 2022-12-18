# Topic: Behavioral Patterns.
### Course: TMPS
### Author: Babcinetchi Egor

----
### Introduction
In this laboratory work I have studied and implemented 5 behavioral patterns:
1. Strategy
2. Template Method
3. Visitor
4. Observer
5. Iterator

The reason behind choosing these patterns is their popularity and utility. These patterns are used 
almost in every framework known by me. Personally I think these 5 patterns are the most useful from the whole list. 
Of course each pattern in the standard list has its utility and should be studied for eventual use
<br>
The system I developed to show the usage of these patterns is a mail writer system, let us call it a *"pseudo-mailwriter bot"*
that takes some content and transforms it to an email that is sent to a mail agent (Gmail, Outlook, Yahoo). 
### Strategy 
Strategy is one of the most commonly used design patterns. It is design around the idea of enhancing the main properties 
of OOP and add new flavour to existing features of OOP languages.
<br> 
Strategy's main point is to get rid of inheritance when using polymorphism. It allows using various method based on runtime 
logic without affecting thw whole system. 
<br>
Strategy works like polymorphism - based on a common algorithm there are created particular *strategies* that can be 
added and removed to the *context* and used by it in particular situations.
<br>
In my system *Strategy* is used to design MailWriters to generate and send emails to a particular agent.
<br>
There is a main MailWriter class 
```
class MailWriter {
    abstract String sendMail(Mail mail);
    abstract String toXml(Mail mail, Visitor visitor);

    public String getHeader(Mail mail) { ... }
    public String getBlankLine() { ... }

    public String getFooter() {...}

    abstract void log(String data);
}
```

that performs generation of an email, sending it to a provider and logging data about each email sent.
<br>
There are also 3 child classes:
* ```class GmailMail {...}```
* ```class OutlookMail {...}```
* ```class YahooMail {...}```

that extend ```class MailWriter``` and implements its abstract methods. The
*strategies* in this case is method ```abstract String sendMail(Mail mail)``` and ```abstract String toXml(Mail mail, Visitor visitor)```.
These methods perform their own logic of generating and sending emails, and xml-file generation.
<br>
The *context* here is ```class MailClient``` that sends the emails. The context is designed to perform setting of and delegating the sending to
strategy ie ```private MailWriter writer```.
<br>
In the ```class Main``` there is a simulation of the mail writer bot. 
<br>
![s1.png](..%2F..%2Fresources%2Fs1.png)
<br>
In the image there is the result of ```sendMail(String )``` 
<br>

![s2.png](..%2F..%2Fresources%2Fs2.png)

Here the previously set ```class GmailMail``` is used.
<br>
In conclusion strategy is useful to add new functionality without changing the main algorithm. It is useful in complex 
systems where there are required different and complex logic for common algorithms, though it is an overengineering for easier
methods, in these cases polymorphism is enough;
### Template Method 
In order to optimize email generation, some common methods were exported to parent class. These methods are:
```
    public String getHeader(Mail mail) { ... }
    public String getBlankLine() { ... }
    public String getFooter() { ... }
```
These methods are combined and used by each of the children. Moreover, the method footer is overriden to support provider-specific 
signature, aka name of the provied (ex: Gmail)
<br>
The methods exported to the parent class are used to generate an email:
```
    String sendMail(Mail mail) {
        ...
        return getHeader(mail) + getBlankLine() + mail.getContent() + getFooter();
    }
```
To conclude, the usage of Template Methods requires some knowladge of the system to identify methods that can be split 
in parts and exporting the common parts to the parent class. In addition, the child class can always modify the original step 
for its individual usage without affecting the main algorithm.
### Visitor
Here, in the Mail Writer app, Visitor pattern is used to add new functionality of exporting emails to XML format without 
affecting the classes in usage.
<br>
There is a Visitor ```class XmlVisitor {...}``` that defines methods to export each class of type *MailWriter* to XML format.
``` 
    public String visitGmail(Mail mail) {...}
    public String visitYahoo(Mail mail) {...}
    public String visitOutlook(Mail mail) {...}
```
In order to access these methods, each MailWriter class has its methods ```toXml(Visitor visitor)``` that uses particular 
methods in Visitor class.
<br>
Visitor pattern is useful for extending classes with additional functional without changing classes (and creating new bugs).
Even though there are added new methods to each MailWriter class, these methods are simple, just accessing the Visitor.
### Observer
In order to keep track of each email sent by MailWriter there was added a logger. But not all mailWriters may need such a 
logger (for example the inactive ones), so for this reason there is needed a subscription system for system logs. These was
done using the Observer pattern.
<br>
Observer pattern is based on a publisher that generates messages , and listeners that listen for messages generated by publisher.
The publisher in the case of implemented project is ```class LoggerPublisher {...}```. It contains methods 
```
  private Set<MailWriter> mailWriters = new HashSet<>();

    public void subscribe(MailWriter mailWriter) { ... }

    public void unsubscribe(MailWriter mailWriter) { ... }

    public void notify(String log) { ...}
```
that performs basic publisher operation: subscription, unsubscription and notification.
<br>
The publisher works with MailWriters. When notification is called, each MailWriter from cache calls its own ```public void log(String data)```
method that writes system logs to corresponding files.
<br>
Here are added two listeners to publisher and generated a new notification to all listeners.
<br>
![o1.png](..%2F..%2Fresources%2Fo1.png)

<br>
Observer is a pattern used specifically to design an event-based system, greatly simplifying binding publishers and listeners.
This pattern can be used also in concurrent programming, especially in producer-consumer problem. Observer offers the possibility to 
change dynamically the listeners subscribed to specific events, useful in real time programming.

### Iterator
The last but not the least is Iterator pattern. It is one of the easiest one, but as useful as others. Iterator is used to
traverse safely a collection without exposing too much information to the client. 
<br>
The Iterator class created by me is ```class MailWriterIterator```. It is a standard Iterator with collection, that is set 
during Iterator initialization, method ```public MailWriter getNext() {...}```, that returns next element in the iterator 
queue and a method that gives whether there is any element left to be processed ```public boolean hasMore()```.
<br>
In the designed system Iterator was integrated into ```class LoggerPublisher``` to access subscribed MailWriters. 
``` 
    public void notify(String log) {
        MailWriterIterator mailWriterIterator = new MailWriterIterator();
        mailWriterIterator.setWriters(mailWriters);
        while (mailWriterIterator.hasMore()) {
            mailWriterIterator.getNext().log(log);
        }
    }
```
As a result, client cannot access directly mailWriters (well, in this case it can, because it has access to the collection. 
Ideally, there should have been created a separate class for these operations, or rethinked system design).
<br>
To conclude, Iterator is one of the most used patterns in an OOP language, at least all Java collection implement Iterator class
, so it is worth to know how it is build and used. Of course, Iterator should not be sued anywhere and everywhere. As any 
other patterns, it has its use cases. The point of this ( and not only) pattern is to know why and when to use in order 
to avoid over engineering and structures that makes the system more complex. Design patterns are meant to make the system 
easier to develop, maintain and expend, not to use just for being used.


