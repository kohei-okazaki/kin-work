# -*- coding:utf-8 -*-
'''
Created on 2019/11/04
ロガーのPython

@since 1.0.0

'''
import datetime
import inspect


class Logger():

    def __init__(self, filepath):
        """
            Content:
                コンストラクタ
            Param:
                1. filepath:    ファイルパス
        """
        self.__filepath = 'C:\kin-app\logs' + filepath

    def write(self, msg):
        """
            Content:
                書き込みメソッド
            Param:
                1. msg: 出力メッセージ
        """
        # スタックフレーム解析
        stack_frame = inspect.stack()[1]
        frame = stack_frame[0]
        info = inspect.getframeinfo(frame)

        # ログファイル内容作成
        linetxt = ""
        linetxt += datetime.datetime.now().strftime("%Y/%m/%d %H:%M:%S ")
        linetxt += (info.filename + " ")
        linetxt += (str(info.lineno) + " ")
        linetxt += msg
        linetxt += "\n"

        # ログファイルに書き込む
        with open(self.__filepath, "w", encoding='utf-8') as f:
            f.write(linetxt)
