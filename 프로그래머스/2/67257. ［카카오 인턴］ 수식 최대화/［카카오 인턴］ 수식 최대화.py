import itertools


def solution(expression):
    operation = ["-", "+", "*"]
    a = list(itertools.permutations(operation))


    maximum = []

    for section in a:
        one = expression.split(section[0])
        two = []
        for o in one:
            two.append(o.split(section[1]))

        print(two)

        three = []
        for t in two:
            if len(t) == 1 and section[2] in t[0]:
                temp = []
                temp.append(str(eval(t[0])))
                three.append(temp)
            else:
                temp = []
                for tt in t:
                    temp.append(str(eval(tt)))
                three.append(temp)
        result = []
        for th in three:
            if len(th) >= 2:
                result.append(str(eval(section[1].join(th))))
            else:
                result.append(str(eval(th[0])))

        maximum.append(abs(eval(section[0].join(result))))

    return max(maximum)