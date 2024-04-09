package com.ilyes.firebaseauth.auth.sign_up;

import com.ilyes.firebaseauth.domain.repository.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SignUpViewModel_Factory implements Factory<SignUpViewModel> {
  private final Provider<AuthRepository> repoProvider;

  public SignUpViewModel_Factory(Provider<AuthRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public SignUpViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static SignUpViewModel_Factory create(Provider<AuthRepository> repoProvider) {
    return new SignUpViewModel_Factory(repoProvider);
  }

  public static SignUpViewModel newInstance(AuthRepository repo) {
    return new SignUpViewModel(repo);
  }
}
