# 2차원 행렬 arr1과 arr2를 입력받아,
# arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

def solution(arr1, arr2):
    answer = [[0 for i in range(len(arr2[0]))] for _ in range(len(arr1))]
    
    # answer과 arr1의 행을 일치시킨다.
    # arr1의 열은 0부터 arr1의 열의 길이만큼 순차적으로 증가한다.
    # arr2의 행의 길이는 arr1의 열의 길이와 동일하다.
    # 3중 for문으로 해결해보자.
    for i in range(len(arr1)):  # 일단 arr1의 행의 길이만큼 반복
        for j in range(len(arr1[0])):  # arr1의 열의 길이만큼 반복
            for k in range(len(arr2[0])):
                answer[i][k] += arr1[i][j] * arr2[j][k]
    
    return answer