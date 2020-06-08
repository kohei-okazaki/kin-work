# -*- coding:utf-8 -*-
'''
Created on 2020/01/18
定時登録画面のテスト

@since 1.0.0

'''
from selenium import webdriver

from src.main.python.common import const_data
from src.main.python.common.logger import Logger
from src.main.python.login.login_auth import LoginAuth
from src.main.python.ontimeregist.ontime_regist import OntimeRegist


def testValidate(driver):
    '''
    妥当性チェックを行う
    '''

    # 必須チェック
    testValidateRequired(driver)

    # 型チェックを行う
    testValidateType(driver)


def testValidateRequired(driver):
    '''
    必須チェックを行う
    '''
    OntimeRegist(driver, "", "", "", "", "").doRegist()


def testValidateType(driver):
    '''
    型チェックを行う
    '''
    OntimeRegist(driver, "12345", "A", "B", "C", "D").doRegist()


''' ここからメイン処理 '''
log = Logger("auto.log")
log.write("AttendTest開始")

# Driverパスを設定する
driver = webdriver.Chrome(const_data.SELENIUM_DRIVER_PATH)

# 管理者ユーザのログイン情報でログイン
loginId = "admin"
password = "adminPass"
LoginAuth(driver, loginId, password).doLogin()

# 定時登録画面へ遷移
driver.find_element_by_link_text(u"定時登録").click()

# 妥当性チェックを行う
testValidate(driver)

# 確認ボタン押下し、定時登録確認画面に遷移
driver.find_element_by_name('submit').click()

log.write("AttendTest終了")
''' ここまでメイン処理 '''
