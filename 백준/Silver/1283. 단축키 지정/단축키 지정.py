keys = set()
N = int(input())


def check_word_first(line):
    words = line.split()
    for i, word in enumerate(words):
        first_char = word[0].upper()
        if first_char not in keys:
            keys.add(first_char)
            words[i] = f"[{word[0]}]{word[1:]}"
            print(" ".join(words))
            return True
    return False


for _ in range(N):
    line = input()
    if not check_word_first(line):
        for i, char in enumerate(line):
            if char == " ":
                continue
            if char.upper() not in keys:
                keys.add(char.upper())
                print(line[:i] + f"[{char}]" + line[i + 1:])
                break
        else:
            print(line)
