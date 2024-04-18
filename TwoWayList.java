package ru.relex.Test_1;

public class TwoWayList implements Remove,Add,Print,Contains{
    public Node head;
    public Node tail;
    public TwoWayList(){
        head = null;
        tail = null;
    }

    private boolean isEmpty(){//проверка на пустоту списка
        return head == null;
    }

    public void add(int info){//добавление в начало
        Node temp = new Node(info);

        if(isEmpty()){
            tail = temp;
        }
        else {
            head.prev = temp;
        }
        temp.next = head;
        head = temp;
    }

    public void print(){//вывод списка
        Node temp = head;

        while (temp != null){
            System.out.println(temp.info);
            temp = temp.next;
        }
    }
    public void addLastInd(int info){//добавление в конец
        Node temp = new Node(info);
        if (isEmpty()){
            head = temp;
        }
        else {
            tail.next = temp;
        }
        temp.prev = tail;
        tail = temp;

    }
    public void addByInd(int info,int ind){//добавление по индексу
        Node cur = head;
        int c = 0;//промежуточная переменная,для возвращения индекса элемента
        while (cur != null && c != ind){
            cur = cur.next;
            c++;
        }

        Node temp = new Node(info);
        cur.prev.next = temp;//вставка элемента по индексу,затирание элементов слева и справа
        temp.prev = cur.prev;
        cur.prev = temp;
        temp.next = cur;

    }

    public void remove(){// удаление первого элемента
        if(head.next == null){
            tail = null;
        }
        else {
            head.next.prev = null;
        }
        head = head.next;
    }
    public void removeLast(){//удаление последнего элемента
        if(head.next == null){
            head = null;
        }
        else {
            tail.prev.next = null;
        }
        tail = tail.prev;
    }
    public void removeAt(int meaning){//Удаление по значению
        Node cur = head;

        while (cur.info != meaning){
            cur = cur.next;

            if(cur == null){
                return;
            }
        }
        if (cur == head){//если текущий элемент является первым,головой удаляем первый элемент
            remove();
        }
        else {
            cur.prev.next = cur.next;//затирание,изменения расположений
        }
        if(cur == tail){
            removeLast();
        }
        else {
            cur.next.prev = cur.prev;//затирание,изменение расположений
        }
    }
    public int contains(int meaning){
        Node temp = head;
        int c = 0;//промежуточная переменная,для возвращения индекса элемента

        while (temp != null){
            if(temp.info == meaning){
                return c;
            }
            temp = temp.next;
            c++;
        }
        return -1;//для оповещения того,что такого значения в нашем списке нет
    }

}