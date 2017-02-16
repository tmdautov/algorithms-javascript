
### Idea
List is a simple data structure for storing elements



### List class implementation

```javascript
var List = function (e) {
    var self = this;
    var first, last, head;

    self.insert = function (value) {
        var node = new Node(value);
        if (first == null) {
            first = last = node;
        } else {
            var head = first;
            while (head.next != null) {
                head = head.next;
            }
            head.next = node;
            last = head.next;
        }
    }

    self.show = function () {
        var head = first;
        while (head != null) {
            console.log(head.value);
            head = head.next;
        }
    }

    self.remove = function (value) {
        var found = false;
        var head = first;
        while (head != null) {
            if (first.value == value) {
                prev = head = first = first.next;
                found = true;
            } else {
                if (head.value == value) {
                    found = true;
                    prev.next = head.next;
                }
                prev = head;
                head = head.next;                            
            }
        }

        if (!found) {
            console.log("#" + value + " not found");
        }
    }

    self.update = function (value, newValue) {
        var head = first;
        while (head != null) {
            if (head.value == value) {
                head.value = newValue;
            }
            head = head.next;
        }

    }

    var Node = function (value) {
        this.value = value;
        var next = {};
    }

    return self;
};

var list = new List();
list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);

list.show();
console.log("____________________________");

list.update(2, 5);           
list.show();
console.log("____________________________");

list.remove(3);
list.show();

```


### Append: adding element to a list
Adds new element to end of list

```javascript
function append(element) {
    this.dataStore[this.listSize++] = element;
}
```
