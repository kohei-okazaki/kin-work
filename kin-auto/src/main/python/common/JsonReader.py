'''
Created on 2020/01/18
JSON読み込み処理を行うPython

@since 1.0.0

'''
import json
from src.main.python.common import ConstData


class JsonReader():

    def __init__(self, filePath):
        '''
        Constructor
        @param filePath: ファイルパス
        '''
        self.filePath = ConstData.BASE_SYSTEM_PATH + '/' + filePath

    def getValue(self, key):
        '''
        JSONから読み込んだデータを辞書型で返す
        '''

        # JSONファイルの読み込みを行う
        with open(self.filePath) as f:
            jsn = json.load(f)

        # jsonの中身を表示する
        print(jsn)

        return jsn([key])
