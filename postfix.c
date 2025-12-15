#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#define MAX 100
// Global stack and top pointer
int stack[MAX];
int top = -1;
// Push an element onto the stack
void push(int value) {
if (top >= MAX - 1) {
printf("Stack Overflow\n");
return;
}
stack[++top] = value;
}
// Pop an element from the stack
int pop() {
if (top == -1) {
printf("Stack Underflow\n");
return 0;
} return stack[top--];
}
// Perform operation on two operands
int performOperation(char operator, int operand1, int operand2) {
switch (operator) {
case '+': return operand1 + operand2;
case '-': return operand1 - operand2;
case '*': return operand1 * operand2;
case '/': return operand1 / operand2; // assumes operand2 != 0
case '%': return operand1 % operand2; // assumes operand2 != 0
case '^': return (int)pow(operand1, operand2);
default: return 0; // Should not reach here for valid expressions
}
}
// Evaluate the postfix expression
int evaluatePostfix(char* expression) {
int len = strlen(expression);
for (int i = 0; i < len; i++) {
char ch = expression[i];
if (isdigit(ch)) {
push(ch - '0');
} else {
int operand2 = pop();
int operand1 = pop();
int result = performOperation(ch, operand1, operand2);
push(result);
}
}
return pop();
}
int main() {
char expression[MAX];
// Read the postfix expression from input
scanf("%s", expression);
// Evaluate and print the result
int result = evaluatePostfix(expression);
printf("%d\n", result);
return 0;
}
