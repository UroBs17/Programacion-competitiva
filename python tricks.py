l=["Hai",123,True]
d={"p1":1,"p2":2,"p3":3}
args={"p1":"hahas","p2":15}
def f1(p1,p2):
    print(p1,p2)
def f2(**args):
    print(args)
def f3(*args):
    print(args)
print(l,*l)#['Hai', 123, True] Hai 123 True
print(d,*d)#{'p1': 1, 'p2': 2, 'p3': 3} p1 p2 p3
f1(**args)#hahas 15
f2(p1="hehe",p2="12",p3=132,p4=True)#{'p1': 'hehe', 'p2': '12', 'p3': 132, 'p4': True}
f3(*l)#('Hai', 123, True)
for ele,ind in enumerate(l):
    print(ele,ind)
name="Jhon"
age=17
s= F"name: {name};age: {age}"
print(s)
l=[i for i in range(10) if i%2==0]
print(*l)
l=[(i,j) for i in range(5) for j in range(5)]
print(*l)
a=["a","b","c","d"]
b=[1,2,3,4]
for i,j in zip(a,b):
    print(i,j)
print("---")
a=["a","b","c"]
b=[1,2,3,4]
for i,j in zip(a,b):
    print(i,j)
