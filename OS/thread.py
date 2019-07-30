import threading

class Thread(threading.Thread):

    def __init__(self, name):
        threading.Thread.__init__(self)
        self.name = name
    
    def run(self):
        for i in range(10):
            print(self.name)

threadA = Thread("A")
threadB = Thread("B")

threadA.start()
threadB.start()