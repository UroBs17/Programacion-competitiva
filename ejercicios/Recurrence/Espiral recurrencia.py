import turtle

def esp(t,l,g):
    if l>0:
        t.width(g)
        t.speed(10)
        t.fd(l)
        t.right(45)
        esp(t, l-10,g-1)
def main():
    san= turtle.Turtle()
    san.penup()
    san.goto(0,200)
    san.pendown()
    esp(san,200,30)
main()
