import turtle

def arbol(l,t,g):
    if l>5:
        t.width(g)
        t.color("brown")
        t.fd(l)
        t.right(20)
        arbol(l-15, t,g-2)
        t.color("green")
        t.left(40)
        arbol(l-15, t,g-2)
        t.right(20)
        t.fd(-l)        
def main():
    san= turtle.Turtle()
    san.left(90)
    arbol(90, san, 10)
main()
