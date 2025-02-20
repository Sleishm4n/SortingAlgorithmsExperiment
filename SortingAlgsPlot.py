import numpy as np
import matplotlib.pyplot as plt

datasets = ['int10.txt', 'int50.txt', 'int100.txt', 'int1000.txt', 'int20k.txt', 'int500k.txt', 'intBig.txt']

insertion_times = [45697460, 14760, 50730, 2640750, 70046570, 40440981810, 53382993510]
selection_times = [32972930, 21460, 55790, 2006760, 110175390, 62467108340, 185284000000]
shell_times = [45899570, 15670, 33300, 421850, 4614380, 69045920, 143982710]
merge_times = [34723130, 30310, 59190, 116250, 901390, 21888850, 48596930]
merge_insertion_times = [14040, 40370, 119650, 167700, 1078680, 31701560, 66356540]
merge_bottomup_times = [302790, 26720, 49990, 156570, 1454160, 24082980, 42977450]
quicksort_times = [42182860, 16220, 35960, 399210, 2299250, 38963100, 77065850]
quicksort_median3_times = [11850, 18300, 30560, 185090, 3138690, 36916290, 68480320]
quickdutch_times = [9490, 13910, 36800, 368270, 1930840, 46562430, 55716010]
quick_insertion_times = [20280, 28880, 30920, 188510, 1715030, 38142760, 76103710]

bar_width = 0.08
index = np.arange(len(datasets))

plt.figure(figsize=(14, 10))

plt.bar(index, insertion_times, bar_width, label='Insertion Sort')
plt.bar(index + bar_width, selection_times, bar_width, label='Selection Sort')
plt.bar(index + 2 * bar_width, shell_times, bar_width, label='Shell Sort')
plt.bar(index + 3 * bar_width, merge_times, bar_width, label='Merge Sort')
plt.bar(index + 4 * bar_width, merge_insertion_times, bar_width, label='Merge Insertion Sort')
plt.bar(index + 5 * bar_width, merge_bottomup_times, bar_width, label='Merge Bottom-Up Sort')
plt.bar(index + 6 * bar_width, quicksort_times, bar_width, label='Quick Sort')
plt.bar(index + 7 * bar_width, quicksort_median3_times, bar_width, label='Quick Sort Median of 3')
plt.bar(index + 8 * bar_width, quickdutch_times, bar_width, label='Quick Dutch Sort')
plt.bar(index + 9 * bar_width, quick_insertion_times, bar_width, label='Quick Insertion Sort')

plt.yscale('log')

plt.xlabel('Datasets')
plt.ylabel('Execution Time (ns)')
plt.title('Sorting Algorithm Execution Times')
plt.xticks(index + 5 * bar_width, datasets, rotation=45)
plt.legend()
plt.grid(True)

plt.show()
