package com.joy.insapi.request.api.followingcancel;

import com.joy.insapi.manager.IGCommonFieldsManager;
import com.joy.insapi.manager.IGConfig;
import com.joy.insapi.manager.utils.IGUtils;
import com.joy.insapi.request.InsBasePostRequest;

public class FollowingCancelRequest extends InsBasePostRequest<FollowingCancelPayload, FollowingCancelResponseData> {

	private String userId;

	public FollowingCancelRequest(String userId) {
		this.userId = userId;
	}

	@Override
	protected String getActionUrl() {
		 return String.format(IGConfig.ACTION_GET_FOLLOWING_CANCEL, userId);
	}

	@Override
	protected FollowingCancelPayload getRequestData() {

		String csrftoken = IGCommonFieldsManager.getInstance().getCsrftoken();
		String pkid = IGCommonFieldsManager.getInstance().getPKID();

		FollowingCancelPayload followingCreatePayload = new FollowingCancelPayload();
		followingCreatePayload.set_csrftoken(csrftoken);
		followingCreatePayload.set_uid(pkid);
		followingCreatePayload.set_uuid(IGUtils.generateUuid(true));
		followingCreatePayload.setUser_id(userId);
		followingCreatePayload.setRadio_type("wifi-none");

		return followingCreatePayload;
	}
}
