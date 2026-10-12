
Day 5 - Inheritance, Polymorphism and Payment Strategy

UML Class Sketch

text
BaseEntity
    |
    +-- Payment (abstract)
    |      |
    |      +-- CardPayment ---- implements Refundable
    |      +-- UPIPayment
    |      +-- CashPayment
    |
    +-- User (abstract)
           |
           +-- Customer
           +-- Admin

PaymentStrategy (interface)
    |
    +-- CardPaymentStrategy
    +-- UpiPaymentStrategy


Concepts Covered
- Inheritance and abstract classes
- Method overloading and overriding
- Runtime polymorphism
- Refundable interface
- Strategy Pattern
- User role hierarchy
- Git branching and merging
